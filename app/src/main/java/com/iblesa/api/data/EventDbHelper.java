package com.iblesa.api.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.iblesa.api.data.EventContract.EventEntry;

public class EventDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "events.db";
    private static final int DATABASE_VERSION = 1;

    public EventDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_EVENT_TABLE = "CREATE TABLE " +
                EventEntry.TABLE_NAME + " (" +
                EventEntry._ID + " TEXT PRIMARY KEY, " +
                EventEntry.COLUMN_EVENT_NAME + " TEXT NOT NULL," +
                EventEntry.COLUMN_EVENT_DATE + " TEXT ," +
                EventEntry.COLUMN_EVENT_TIME + " TEXT ," +
                EventEntry.COLUMN_EVENT_VENUE + " TEXT NOT NULL," +
                EventEntry.COLUMN_EVENT_VENUE_LAT + " TEXT ," +
                EventEntry.COLUMN_EVENT_VENUE_LONG + " TEXT ," +
                EventEntry.COLUMN_EVENT_GENRE + " TEXT NOT NULL," +
                EventEntry.COLUMN_EVENT_SUBGENRE + " TEXT NOT NULL," +
                EventEntry.COLUMN_EVENT_SEGMENT + " TEXT NOT NULL," +
                EventEntry.COLUMN_EVENT_IMAGE + " TEXT NOT NULL" +
                ");";
        db.execSQL(SQL_CREATE_EVENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EventEntry.TABLE_NAME);
        onCreate(db);
    }
}
