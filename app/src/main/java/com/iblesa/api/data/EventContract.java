package com.iblesa.api.data;

import android.provider.BaseColumns;

public class EventContract {
    // Prevent accidentally instantiating of contract class
    private EventContract() {
    }

    public static class EventEntry implements BaseColumns {
        public static final String TABLE_NAME = "events";
        public static final String COLUMN_EVENT_NAME= "name";
        public static final String COLUMN_EVENT_DATE= "date";
        public static final String COLUMN_EVENT_VENUE= "venue";
    }
}
