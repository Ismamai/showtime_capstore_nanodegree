package com.iblesa.api.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.iblesa.showtime.Constants;

public class EventData {
    private String id;
    private String name;
    private String date;
    private String time;
    private String venueName;
    private String venueLat;
    private String venueLong;
    private String genre;
    private String subgenre;
    private String segment;
    private String image;

    public EventData(String id, String name, String date, String time, String venueName, String venueLat, String venueLong, String genre, String subgenre, String segment, String image) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.venueName = venueName;
        this.venueLat = venueLat;
        this.venueLong = venueLong;
        this.genre = genre;
        this.subgenre = subgenre;
        this.segment = segment;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getVenueName() {
        return venueName;
    }

    public String getVenueLat() {
        return venueLat;
    }

    public String getVenueLong() {
        return venueLong;
    }

    public String getGenre() {
        return genre;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public String getSegment() {
        return segment;
    }

    public String getImage() {
        return image;
    }

    public static ContentValues toContentValues(EventData data) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(EventContract.EventEntry._ID, data.getId());
        contentValues.put(EventContract.EventEntry.COLUMN_EVENT_NAME, data.getName());
        contentValues.put(EventContract.EventEntry.COLUMN_EVENT_DATE, data.getDate());
        contentValues.put(EventContract.EventEntry.COLUMN_EVENT_TIME, data.getTime());

        contentValues.put(EventContract.EventEntry.COLUMN_EVENT_VENUE, data.getVenueName());
        contentValues.put(EventContract.EventEntry.COLUMN_EVENT_VENUE_LAT, data.getVenueLat());
        contentValues.put(EventContract.EventEntry.COLUMN_EVENT_VENUE_LONG, data.getVenueLong());
        contentValues.put(EventContract.EventEntry.COLUMN_EVENT_GENRE, data.getGenre());
        contentValues.put(EventContract.EventEntry.COLUMN_EVENT_SUBGENRE, data.getSubgenre());
        contentValues.put(EventContract.EventEntry.COLUMN_EVENT_SEGMENT, data.getSegment());
        contentValues.put(EventContract.EventEntry.COLUMN_EVENT_IMAGE, data.getImage());

        return contentValues;
    }

    public static EventData fromCursor(Cursor cursor) {
        if (cursor.getCount() == 1 && cursor.moveToFirst()) {
            String id = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry._ID));
            String name = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_EVENT_NAME));
            String date = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_EVENT_DATE));
            String time = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_EVENT_TIME));
            String venueName = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_EVENT_VENUE));
            String venueLat = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_EVENT_VENUE_LAT));
            String venueLong = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_EVENT_VENUE_LONG));
            String genre = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_EVENT_GENRE));
            String subgenre = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_EVENT_SUBGENRE));
            String segment = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_EVENT_SEGMENT));
            String image = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_EVENT_IMAGE));
            return new EventData(id, name, date, time, venueName,
                    venueLat, venueLong, genre, subgenre, segment, image);
        }
        Log.e(Constants.TAG, "Error retrieving EventData from Cursor");
        return null;
    }
}
