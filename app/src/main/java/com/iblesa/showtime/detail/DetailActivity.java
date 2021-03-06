package com.iblesa.showtime.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblesa.api.data.EventData;
import com.iblesa.showtime.Constants;
import com.iblesa.showtime.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.apache.commons.lang.StringUtils;


import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.event_detail_name)
    TextView mEventName;

    @BindView(R.id.event_detail_image)
    ImageView mEventImage;

    @BindView(R.id.event_detail_date)
    TextView mEventDate;

    @BindView(R.id.event_detail_venue)
    TextView mEventVenue;

    @BindView(R.id.event_detail_segment)
    TextView mEventSegment;

    @BindView(R.id.event_detail_genre)
    TextView mEventGenre;

    @BindView(R.id.event_detail_subgenre)
    TextView mEventSubgenre;

    private static final int EVENT_LOADER_ID = 11;

    private LoaderManager.LoaderCallbacks<EventData> eventLoader = new LoaderManager.LoaderCallbacks<EventData>() {

        @NonNull
        @Override
        public android.support.v4.content.Loader<EventData> onCreateLoader(int id, @Nullable Bundle args) {
            String eventID = args.getString(Constants.LOADER_PARAM_EVENT_ID);

            return new EventLoader(getApplicationContext(), eventID);
        }

        @Override
        public void onLoadFinished(@NonNull android.support.v4.content.Loader<EventData> loader, EventData data) {
            populateUI(data);
        }

        @Override
        public void onLoaderReset(@NonNull android.support.v4.content.Loader<EventData> loader) {

        }


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        String eventId = getIntent().getStringExtra(Constants.EVENT_ID);
        Bundle queryBundle = new Bundle();
        queryBundle.putString(Constants.LOADER_PARAM_EVENT_ID, eventId);

        getSupportLoaderManager().initLoader(EVENT_LOADER_ID, queryBundle, eventLoader);
    }

    @NonNull
    private void populateUI(final EventData event) {

        new AsyncTaskImage(event, mEventImage).execute();

        mEventName.setText(event.getName());
        mEventVenue.setText(event.getVenueName());
        String venueLat = event.getVenueLat();
        if (TextUtils.isEmpty(venueLat)) {
            venueLat="0";
        }
        String venueLong = event.getVenueLong();
        if (TextUtils.isEmpty(venueLong)) {
            venueLong="0";
        }
        final String location = "geo:" + venueLat
                + "," + venueLong + "?q=" + event.getVenueName();

        StringBuilder date = new StringBuilder();
        if (!StringUtils.isEmpty(event.getDate())) {
            date.append(event.getDate());
        }
        if (!StringUtils.isEmpty(event.getTime())) {
            date.append(" at ").append(event.getTime());
        }

        mEventDate.setText(date.toString());
        mEventSegment.setText(event.getSegment());
        mEventGenre.setText(event.getGenre());
        mEventSubgenre.setText(event.getSubgenre());

        String message = String.format("Genre: %s \nSubgenre: %s \nSegment %s",
                event.getGenre(), event.getSubgenre(), event.getSegment());
        Log.d(Constants.TAG, message);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(Constants.TAG, "Opening location " + location);
                Uri gmmIntentUri = Uri.parse(location);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                Snackbar.make(view, getString(R.string.open_venue_location), Snackbar.LENGTH_LONG)
                        .show();
            }
        });
    }

    class AsyncTaskImage extends AsyncTask<Void, Void, Void> {
        private EventData eventData;
        private ImageView imageView;
        RequestCreator creator;

        AsyncTaskImage(EventData eventData, ImageView imageView) {
            this.eventData = eventData;

            this.imageView = imageView;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            creator = Picasso.get()
                    .load(eventData.getImage())
                    .placeholder(R.drawable.progress_image)
                    .error(R.drawable.progress_image);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            creator.into(imageView);

        }
    }
}
