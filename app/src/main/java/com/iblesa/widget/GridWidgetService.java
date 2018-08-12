package com.iblesa.widget;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.iblesa.api.data.EventContract;
import com.iblesa.showtime.Constants;
import com.iblesa.showtime.R;

public class GridWidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new GridRemoteViewsFactory(this.getApplicationContext());
    }

    static class GridRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

        Context mContext;
        Cursor mCursor;

        public GridRemoteViewsFactory(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public void onCreate() {

        }

        @Override
        public void onDataSetChanged() {
            if (mCursor != null) {
                mCursor.close();
            }
            Uri EVENTS_URI = EventContract.EventEntry.CONTENT_URI;
            try {
                mCursor = mContext.getContentResolver().query(EVENTS_URI, null, null, null, null);
            } catch (Exception e) {
                Log.e(Constants.TAG, "Failed to asynchronously load data.");
                e.printStackTrace();
                mCursor = null;
            }

        }

        @Override
        public void onDestroy() {

        }

        @Override
        public int getCount() {
            if (mCursor == null) {
                return 0;
            } else {
                return mCursor.getCount();
            }
        }

        @Override
        public RemoteViews getViewAt(int position) {
            RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.widget_event_item);
            if (mCursor.moveToPosition(position)) {
                String eventName = mCursor.getString(mCursor.getColumnIndex(EventContract.EventEntry.COLUMN_EVENT_NAME));
                String eventDate = mCursor.getString(mCursor.getColumnIndex(EventContract.EventEntry.COLUMN_EVENT_DATE));
                String entry = "- " + eventDate + " - " + eventName;
                views.setTextViewText(R.id.tv_widget_event_item, entry);
                return views;
            }
            return null;
        }

        @Override
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override
        public int getViewTypeCount() {
            // Treat all items in the GridView the same
            return 1;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

    }
}
