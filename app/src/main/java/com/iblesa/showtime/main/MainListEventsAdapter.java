package com.iblesa.showtime.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.iblesa.api.models.EventResponse;

public class MainListEventsAdapter extends RecyclerView.Adapter<MainListEventsAdapter.EventViewHolder> {
    private EventResponse mEventResponse;
    private final Context context;

    public MainListEventsAdapter(Context context) {
        this.context = context;
    }

    public void setEventResponse(EventResponse eventResponse) {
        this.mEventResponse = eventResponse;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (mEventResponse == null) {
            return 0;
        } else {
            return mEventResponse.getEmbedded().getEvents().size();

        }
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {

        public EventViewHolder(View itemView) {
            super(itemView);
        }
    }
}
