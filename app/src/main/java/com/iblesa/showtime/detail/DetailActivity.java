package com.iblesa.showtime.detail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblesa.api.models.Event;
import com.iblesa.showtime.Constants;
import com.iblesa.showtime.R;
import com.iblesa.util.EventExtractor;
import com.squareup.picasso.Picasso;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Event event = (Event) getIntent().getParcelableExtra(Constants.EVENT_PARCEL);
        String image = EventExtractor.getImage(event);
        Picasso.get()
                .load(image)
                .placeholder(R.drawable.progress_image)
                .error(R.drawable.progress_image)
                .into(mEventImage);
        String eventName = event.getName();
        mEventName.setText(eventName);
        String eventVenue = EventExtractor.getVenue(event);
        mEventVenue.setText(eventVenue);

        mEventDate.setText("Now");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
