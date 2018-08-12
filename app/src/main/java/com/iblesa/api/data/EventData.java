package com.iblesa.api.data;

import android.content.ContentValues;

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
}
