package com.iblesa.showtime.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblesa.api.models.Classification;
import com.iblesa.api.models.Event;
import com.iblesa.api.models.Location;
import com.iblesa.api.models.Start;
import com.iblesa.api.models.Venue_;
import com.iblesa.showtime.Constants;
import com.iblesa.showtime.R;
import com.iblesa.util.EventExtractor;
import com.squareup.picasso.Picasso;

import org.apache.commons.lang.StringUtils;

import java.util.List;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Event event = getIntent().getParcelableExtra(Constants.EVENT_PARCEL);
        String image = EventExtractor.getImage(event);
        Picasso.get()
                .load(image)
                .placeholder(R.drawable.progress_image)
                .error(R.drawable.progress_image)
                .into(mEventImage);
        String eventName = event.getName();
        mEventName.setText(eventName);
        Venue_ eventVenue = EventExtractor.getVenue(event);
        mEventVenue.setText(eventVenue.getName());
        Location eventVenueLocation = eventVenue.getLocation();
        final String location = "geo:" + eventVenueLocation.getLatitude()
                +","+eventVenueLocation.getLongitude()+"?q="+eventVenue.getName();
        Start dates = EventExtractor.getDate(event);
        String localDate = dates.getLocalDate();
        String localTime = dates.getLocalTime();

        StringBuilder date = new StringBuilder();
        if (!StringUtils.isEmpty(localDate)) {
            date.append(localDate);
        }
        if (!StringUtils.isEmpty(localTime)) {
            date.append(" at ").append(localTime);
        }

        mEventDate.setText(date.toString());

        List<Classification> classifications = event.getClassifications();

        String genre = null;
        String segment = null;
        String subGenre = null;
        if (classifications.size() > 0) {
            Classification classification = classifications.get(0);
            segment = classification.getSegment().getName();
            mEventSegment.setText(segment);

            genre = classification.getGenre().getName();
            mEventGenre.setText(genre);

            subGenre = classification.getSubGenre().getName();
            mEventSubgenre.setText(subGenre);

        }
        String message = String.format("Genre: %s \nSubgenre: %s \nSegment %s", genre, subGenre, segment);
        Log.d(Constants.TAG, message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
