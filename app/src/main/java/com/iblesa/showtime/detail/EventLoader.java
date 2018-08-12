package com.iblesa.showtime.detail;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.AsyncTaskLoader;

import com.iblesa.api.data.EventContract;
import com.iblesa.api.data.EventData;

public class EventLoader extends AsyncTaskLoader<EventData> {

    private String eventId;

    public EventLoader(Context context, String eventId) {
        super(context);
        this.eventId = eventId;
    }

    @Override
    public EventData loadInBackground() {
        Uri contentUri = EventContract.EventEntry.CONTENT_URI;
        contentUri = contentUri.buildUpon().appendPath(eventId).build();
        Cursor cursor = getContext().getContentResolver().query(contentUri,
                null,
                null,
                null,
                null);
        return EventData.fromCursor(cursor);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
