package com.iblesa.api.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class EventContract {

    public static final String AUTHORITY = "com.iblesa.showtime";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+AUTHORITY);

    public static final String PATH_EVENTS = "events";

    // Prevent accidentally instantiating of contract class
    private EventContract() {
    }

    public static class EventEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_EVENTS)
                .build();

        public static final String TABLE_NAME = "events";
        public static final String COLUMN_EVENT_NAME= "name";
        public static final String COLUMN_EVENT_DATE= "date";
        public static final String COLUMN_EVENT_VENUE= "venue";
    }
}
