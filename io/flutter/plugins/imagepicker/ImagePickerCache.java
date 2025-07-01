package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import io.flutter.plugins.imagepicker.Messages;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
class ImagePickerCache {
    private static final String FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY = "flutter_image_picker_image_path";
    static final String MAP_KEY_ERROR = "error";
    static final String MAP_KEY_IMAGE_QUALITY = "imageQuality";
    static final String MAP_KEY_MAX_HEIGHT = "maxHeight";
    static final String MAP_KEY_MAX_WIDTH = "maxWidth";
    static final String MAP_KEY_PATH_LIST = "pathList";
    static final String MAP_KEY_TYPE = "type";
    private static final String MAP_TYPE_VALUE_IMAGE = "image";
    private static final String MAP_TYPE_VALUE_VIDEO = "video";
    static final String SHARED_PREFERENCES_NAME = "flutter_image_picker_shared_preference";
    private static final String SHARED_PREFERENCE_ERROR_CODE_KEY = "flutter_image_picker_error_code";
    private static final String SHARED_PREFERENCE_ERROR_MESSAGE_KEY = "flutter_image_picker_error_message";
    private static final String SHARED_PREFERENCE_IMAGE_QUALITY_KEY = "flutter_image_picker_image_quality";
    private static final String SHARED_PREFERENCE_MAX_HEIGHT_KEY = "flutter_image_picker_max_height";
    private static final String SHARED_PREFERENCE_MAX_WIDTH_KEY = "flutter_image_picker_max_width";
    private static final String SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY = "flutter_image_picker_pending_image_uri";
    private static final String SHARED_PREFERENCE_TYPE_KEY = "flutter_image_picker_type";
    private final Context context;

    /* loaded from: classes4.dex */
    public enum CacheType {
        IMAGE,
        VIDEO
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImagePickerCache(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveType(CacheType cacheType) {
        int ordinal = cacheType.ordinal();
        if (ordinal == 0) {
            setType("image");
        } else {
            if (ordinal != 1) {
                return;
            }
            setType("video");
        }
    }

    private void setType(String str) {
        this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit().putString(SHARED_PREFERENCE_TYPE_KEY, str).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveDimensionWithOutputOptions(Messages.ImageSelectionOptions imageSelectionOptions) {
        SharedPreferences.Editor edit = this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
        if (imageSelectionOptions.getMaxWidth() != null) {
            edit.putLong(SHARED_PREFERENCE_MAX_WIDTH_KEY, Double.doubleToRawLongBits(imageSelectionOptions.getMaxWidth().doubleValue()));
        }
        if (imageSelectionOptions.getMaxHeight() != null) {
            edit.putLong(SHARED_PREFERENCE_MAX_HEIGHT_KEY, Double.doubleToRawLongBits(imageSelectionOptions.getMaxHeight().doubleValue()));
        }
        edit.putInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, imageSelectionOptions.getQuality().intValue());
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void savePendingCameraMediaUriPath(Uri uri) {
        this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit().putString(SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY, uri.getPath()).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String retrievePendingCameraMediaUriPath() {
        return this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).getString(SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveResult(ArrayList<String> arrayList, String str, String str2) {
        SharedPreferences.Editor edit = this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
        if (arrayList != null) {
            edit.putStringSet(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY, new HashSet(arrayList));
        }
        if (str != null) {
            edit.putString(SHARED_PREFERENCE_ERROR_CODE_KEY, str);
        }
        if (str2 != null) {
            edit.putString(SHARED_PREFERENCE_ERROR_MESSAGE_KEY, str2);
        }
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit().clear().apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> getCacheMap() {
        Messages.CacheRetrievalType cacheRetrievalType;
        Set<String> stringSet;
        HashMap hashMap = new HashMap();
        boolean z = false;
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        boolean z2 = true;
        if (sharedPreferences.contains(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY) && (stringSet = sharedPreferences.getStringSet(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY, null)) != null) {
            hashMap.put(MAP_KEY_PATH_LIST, new ArrayList(stringSet));
            z = true;
        }
        if (sharedPreferences.contains(SHARED_PREFERENCE_ERROR_CODE_KEY)) {
            Messages.CacheRetrievalError.Builder builder = new Messages.CacheRetrievalError.Builder();
            builder.setCode(sharedPreferences.getString(SHARED_PREFERENCE_ERROR_CODE_KEY, ""));
            if (sharedPreferences.contains(SHARED_PREFERENCE_ERROR_MESSAGE_KEY)) {
                builder.setMessage(sharedPreferences.getString(SHARED_PREFERENCE_ERROR_MESSAGE_KEY, ""));
            }
            hashMap.put("error", builder.build());
        } else {
            z2 = z;
        }
        if (z2) {
            if (sharedPreferences.contains(SHARED_PREFERENCE_TYPE_KEY)) {
                if (sharedPreferences.getString(SHARED_PREFERENCE_TYPE_KEY, "").equals("video")) {
                    cacheRetrievalType = Messages.CacheRetrievalType.VIDEO;
                } else {
                    cacheRetrievalType = Messages.CacheRetrievalType.IMAGE;
                }
                hashMap.put("type", cacheRetrievalType);
            }
            if (sharedPreferences.contains(SHARED_PREFERENCE_MAX_WIDTH_KEY)) {
                hashMap.put(MAP_KEY_MAX_WIDTH, Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(SHARED_PREFERENCE_MAX_WIDTH_KEY, 0L))));
            }
            if (sharedPreferences.contains(SHARED_PREFERENCE_MAX_HEIGHT_KEY)) {
                hashMap.put(MAP_KEY_MAX_HEIGHT, Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(SHARED_PREFERENCE_MAX_HEIGHT_KEY, 0L))));
            }
            hashMap.put(MAP_KEY_IMAGE_QUALITY, Integer.valueOf(sharedPreferences.getInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, 100)));
        }
        return hashMap;
    }
}
