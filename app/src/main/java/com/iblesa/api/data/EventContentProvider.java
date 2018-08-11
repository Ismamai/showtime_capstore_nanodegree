package com.iblesa.api.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.iblesa.api.data.EventContract.EventEntry.TABLE_NAME;

public class EventContentProvider extends ContentProvider {
    private EventDbHelper mEventDbHelper;

    private static final int EVENTS = 100;

    public static final UriMatcher sUriMatcher = buildUtiMatcher();

    public static UriMatcher buildUtiMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        //List all events
        uriMatcher.addURI(EventContract.AUTHORITY, EventContract.PATH_EVENTS, EVENTS);

        return uriMatcher;
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        mEventDbHelper = new EventDbHelper(context);

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        final SQLiteDatabase db = mEventDbHelper.getReadableDatabase();
        int match = sUriMatcher.match(uri);
        Cursor retCursor;
        switch (match) {
            case EVENTS:
                retCursor = db.query(TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            default:
                throw new UnsupportedOperationException("Unknown URI: " + uri);

        }
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return retCursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final SQLiteDatabase db = mEventDbHelper.getWritableDatabase();

        int matchCode = sUriMatcher.match(uri);
        Uri returnURI;
        switch (matchCode) {
            case EVENTS:
                long id = db.insert(TABLE_NAME, null, values);
                if (id > 0) {
                    returnURI = ContentUris.withAppendedId(EventContract.EventEntry.CONTENT_URI, id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            default:
                throw new UnsupportedOperationException("Unknown URI: " + uri);

        }
        //Notify the resolver that the uri has changed
        getContext().getContentResolver().notifyChange(returnURI, null);

        return returnURI;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase db = mEventDbHelper.getWritableDatabase();

        int matchCode = sUriMatcher.match(uri);
        int deleted;
        switch (matchCode) {
            case EVENTS:
                deleted = db.delete(TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown URI: " + uri);

        }
        return deleted;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
