package com.amolg.flutterbarcodescanner.widget;

import java.util.Map;

/* loaded from: classes3.dex */
public class ParamData {
    private final Integer cameraFace;
    private final Boolean continuous;
    private final Long delayMillis;
    private final String key;
    private final Integer scanType;
    private final Integer scannerHeight;
    private final Integer scannerWidth;

    public ParamData(String str, Integer num, Integer num2, Long l, Boolean bool, Integer num3, Integer num4) {
        this.key = str;
        this.scanType = num;
        this.cameraFace = num2;
        this.delayMillis = l;
        this.continuous = bool;
        this.scannerWidth = num3;
        this.scannerHeight = num4;
    }

    public String getKey() {
        return this.key;
    }

    public Integer getScanType() {
        return this.scanType;
    }

    public Integer getCameraFace() {
        return this.cameraFace;
    }

    public Long getDelayMillis() {
        return this.delayMillis;
    }

    public Boolean isContinuous() {
        return this.continuous;
    }

    public Integer getScannerWidth() {
        return this.scannerWidth;
    }

    public Integer getScannerHeight() {
        return this.scannerHeight;
    }

    public static ParamData fromMap(Map<String, Object> map) {
        return new ParamData((String) map.get("key"), (Integer) map.get("scanType"), (Integer) map.get("cameraFace"), (Long) map.get("delayMillis"), (Boolean) map.get("continuous"), (Integer) map.get("scannerWidth"), (Integer) map.get("scannerHeight"));
    }
}
