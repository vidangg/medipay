package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class CharEscaperBuilder {
    private int max = -1;
    private final Map<Character, String> map = new HashMap();

    /* loaded from: classes4.dex */
    private static class CharArrayDecorator extends CharEscaper {
        private final int replaceLength;
        private final char[][] replacements;

        CharArrayDecorator(char[][] replacements) {
            this.replacements = replacements;
            this.replaceLength = replacements.length;
        }

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String s) {
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char charAt = s.charAt(i);
                char[][] cArr = this.replacements;
                if (charAt < cArr.length && cArr[charAt] != null) {
                    return escapeSlow(s, i);
                }
            }
            return s;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.escape.CharEscaper
        @CheckForNull
        public char[] escape(char c) {
            if (c < this.replaceLength) {
                return this.replacements[c];
            }
            return null;
        }
    }

    public CharEscaperBuilder addEscape(char c, String r) {
        this.map.put(Character.valueOf(c), (String) Preconditions.checkNotNull(r));
        if (c > this.max) {
            this.max = c;
        }
        return this;
    }

    public CharEscaperBuilder addEscapes(char[] cs, String r) {
        Preconditions.checkNotNull(r);
        for (char c : cs) {
            addEscape(c, r);
        }
        return this;
    }

    public char[][] toArray() {
        char[][] cArr = new char[this.max + 1];
        for (Map.Entry<Character, String> entry : this.map.entrySet()) {
            cArr[entry.getKey().charValue()] = entry.getValue().toCharArray();
        }
        return cArr;
    }

    public Escaper toEscaper() {
        return new CharArrayDecorator(toArray());
    }
}
