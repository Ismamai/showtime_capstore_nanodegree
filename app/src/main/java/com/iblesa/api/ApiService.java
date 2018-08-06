package com.iblesa.api;

import com.iblesa.api.models.EventResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    //https://app.ticketmaster.com/discovery/v2/events.json?apikey=key_here
    @GET("events.json")
    Call<EventResponse> listEvents(@Query("apikey") String apikey, @Query("latlong") String latlong);
}
