package com.dexterous.flutterlocalnotifications.models;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes3.dex */
public class NotificationChannelGroupDetails implements Serializable {
    private static final String DESCRIPTION = "description";
    private static final String ID = "id";
    private static final String NAME = "name";
    public String description;
    public String id;
    public String name;

    public static NotificationChannelGroupDetails from(Map<String, Object> map) {
        NotificationChannelGroupDetails notificationChannelGroupDetails = new NotificationChannelGroupDetails();
        notificationChannelGroupDetails.id = (String) map.get("id");
        notificationChannelGroupDetails.name = (String) map.get("name");
        notificationChannelGroupDetails.description = (String) map.get(DESCRIPTION);
        return notificationChannelGroupDetails;
    }
}
