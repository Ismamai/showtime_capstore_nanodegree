package com.iblesa.showtime.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iblesa.api.models.Embedded_;
import com.iblesa.api.models.Event;
import com.iblesa.api.models.EventResponse;
import com.iblesa.api.models.Image;
import com.iblesa.showtime.Constants;
import com.iblesa.showtime.R;
import com.iblesa.showtime.detail.DetailActivity;
import com.iblesa.util.EventExtractor;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainListEventsAdapter extends RecyclerView.Adapter<MainListEventsAdapter.EventViewHolder> {
    private EventResponse mEventResponse;
    private final Context mContext;

    public MainListEventsAdapter(Context context) {
        this.mContext = context;
    }

    public void setEventResponse(EventResponse eventResponse) {
        this.mEventResponse = eventResponse;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.master_event_list_item, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.bind(mEventResponse.getEmbedded().getEvents().get(position));

    }

    @Override
    public int getItemCount() {
        if (mEventResponse == null) {
            return 0;
        } else {
            return mEventResponse.getEmbedded().getEvents().size();

        }
    }

    public void clear() {
        mEventResponse = null;
        notifyDataSetChanged();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.event_item_name)
        TextView event_name;
        @BindView(R.id.event_item_image)
        ImageView event_image;
        @BindView(R.id.event_item_venue)
        TextView event_venue;


        public EventViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            Log.d(Constants.TAG, "Created ViewHolder " + this);

        }

        void bind(Event event) {

            String image = EventExtractor.getImage(event);
            Picasso.get()
                    .load(image)
                    .placeholder(R.drawable.progress_image)
                    .error(R.drawable.progress_image)
                    .into(event_image);
            String eventName = event.getName();
            event_name.setText(eventName);
            String eventVenue = EventExtractor.getVenue(event).getName();
            event_venue.setText(eventVenue);
            String message = String.format("Data to show in recyclerview is event %s venue %s %s",
                    eventName,
                    eventVenue, image);
            Log.d(Constants.TAG, message);

        }

              @Override
        public void onClick(View v) {
            Event event = mEventResponse.getEmbedded().getEvents().get(getAdapterPosition());
            Log.d(Constants.TAG, "Selected element " +
                    event);
            //Open detail activity
            Intent detailActivity = new Intent(mContext, DetailActivity.class);
            detailActivity.putExtra(Constants.EVENT_PARCEL, event);
            mContext.startActivity(detailActivity);
        }
    }
}
