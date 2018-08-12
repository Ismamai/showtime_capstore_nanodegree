package com.iblesa.showtime.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblesa.api.data.EventData;
import com.iblesa.showtime.Constants;
import com.iblesa.showtime.R;
import com.squareup.picasso.Picasso;

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
    private void populateUI(EventData event) {
        Picasso.get()
                .load(event.getImage())
                .placeholder(R.drawable.progress_image)
                .error(R.drawable.progress_image)
                .into(mEventImage);
        mEventName.setText(event.getName());
        mEventVenue.setText(event.getVenueName());
        final String location = "geo:" + event.getVenueLat()
                + "," + event.getVenueLong() + "?q=" + event.getVenueName();

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
