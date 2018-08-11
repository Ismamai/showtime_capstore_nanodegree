package com.iblesa.api.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.iblesa.api.models.Event;

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
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
