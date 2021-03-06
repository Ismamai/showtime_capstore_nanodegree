package com.iblesa.showtime.main;

import android.Manifest;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.iblesa.api.ApiClient;
import com.iblesa.api.ApiService;
import com.iblesa.api.data.EventContract;
import com.iblesa.api.data.EventData;
import com.iblesa.api.error.APIError;
import com.iblesa.api.error.ErrorUtils;
import com.iblesa.api.models.Event;
import com.iblesa.api.models.EventResponse;
import com.iblesa.showtime.Constants;
import com.iblesa.showtime.R;
import com.iblesa.util.EventExtractor;
import com.iblesa.widget.ShowtimeWidget;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final int PERMISSION_ACCESS_COARSE_LOCATION = 1234;
    private static final String LAST_LOCATION_LATITUDE = "LATITUDE";
    private static final String LAST_LOCATION_LOGITUDE = "LONGITUDE";
    private static final String SAVED_LAYOUT_MANAGER = "SAVED_LAYOUT_MANAGER";
    private double mLatitude = Constants.DEFAULT_LOCATION_LAT;
    private double mLongitude = Constants.DEFAULT_LOCATION_LON;

    MainListEventsAdapter mAdapter;

    @BindView(R.id.rv_events)
    RecyclerView rvEvents;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefresh;

    Parcelable mLayoutManagerSavedState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        checkLocationEnabled();
        rvEvents.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MainListEventsAdapter(this);
        rvEvents.setAdapter(mAdapter);

        rvEvents.addItemDecoration(new DividerItemDecoration(rvEvents.getContext(),
                DividerItemDecoration.VERTICAL));

        mSwipeRefresh.setOnRefreshListener(this);

        mSwipeRefresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


    }

    private void checkLocationEnabled() {
        //Check if we have already permission for location
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    PERMISSION_ACCESS_COARSE_LOCATION);
        } else {
            FusedLocationProviderClient mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
            mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        mLatitude = location.getLatitude();
                        mLongitude = location.getLongitude();
                        String message = String.format("My location is latitude %s and longitude %s", mLatitude, mLongitude);
                        Log.d(Constants.TAG, message);
                    } else {
                        Log.d(Constants.TAG, "Using default location");
                    }
                    loadData();
                }
            });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_ACCESS_COARSE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Location granted
                    loadData();
                } else {
                    Toast.makeText(this, R.string.LOCATION_IS_REQUIRED, Toast.LENGTH_LONG).show();
                    if (mSwipeRefresh.isRefreshing()) {
                        mSwipeRefresh.setRefreshing(false);
                    }
                }
        }
    }

    /**
     * Trigger data load from remote api.
     */
    private void loadData() {
        String key = getString(R.string.ticketmaster_api_key);
        checkConnectivity();
        Retrofit apiClient = ApiClient.getClient();
        ApiService service = apiClient.create(ApiService.class);
        String latlong = mLatitude + "," + mLongitude;
        Call<EventResponse> listCall;
        listCall = service.listEvents(key, latlong);
        listCall.enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful()) {

                    mAdapter.clear();
                    EventResponse eventResponse = response.body();
                    int size = 0;
                    List<com.iblesa.api.models.Event> events;
                    if (eventResponse != null && eventResponse.getEmbedded() != null) {
                        events = eventResponse.getEmbedded().getEvents();
                        if (events != null) {
                            size = events.size();
                        }

                        String message = String.format("Setting events (%s) %s", size, events);
                        Log.d(Constants.TAG, message);

                        mAdapter.setEventResponse(eventResponse);
                        mSwipeRefresh.setRefreshing(false);

                        populateDB(eventResponse);

                        restoreLayoutManagerPostion();
                    } else {
                        Toast.makeText(MainActivity.this, R.string.ERROR_NO_EVENTS, Toast.LENGTH_LONG).show();
                        Log.e(Constants.TAG, getString(R.string.ERROR_NO_EVENTS));
                    }
                } else {
                    APIError apiError = ErrorUtils.parseError(response);
                    String fault = null;
                    if (apiError.getFault() != null && apiError.getFault().getFaultstring() != null) {
                        fault = apiError.getFault().getFaultstring();
                    }
                    String error = getString(R.string.ERROR_CONTACTING_SERVER, response.code(), fault);
                    Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show();
                    Log.e(Constants.TAG, error);
                }

            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                String error = getString(R.string.ERROR_LOADING_DATA);
                Log.e(Constants.TAG, error, t);
                showError(error);
            }
        });
    }

    /**
     * Populates the database with the data extracte from EventReponse coming from TicketMaster API
     * @param eventResponse contains response from TicketMaster API
     */
    private void populateDB(EventResponse eventResponse) {
        int delete = getContentResolver().delete(EventContract.EventEntry.CONTENT_URI, null, null);
        Log.d(Constants.TAG, "Deleted " + delete);
        for (Event event : eventResponse.getEmbedded().getEvents()) {
            EventData eventData = EventExtractor.extractEventData(event);
            EventData.toContentValues(eventData);
            ContentValues contentValues = EventData.toContentValues(eventData);


            getContentResolver().insert(EventContract.EventEntry.CONTENT_URI, contentValues);
            Log.d(Constants.TAG, "Inserting data " + contentValues);
        }

        // Update widgets
        Context context = getApplicationContext();
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, ShowtimeWidget.class));
        //Trigger data update to handle the GridView widgets and force a data refresh
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.widget_grid_view);
        ShowtimeWidget.updateWidgets(context, appWidgetManager, appWidgetIds);
    }

    private void restoreLayoutManagerPostion() {
        if (mLayoutManagerSavedState != null) {
            rvEvents.getLayoutManager().onRestoreInstanceState(mLayoutManagerSavedState);
        }

    }

    /**
     * Checks that there is internet connectivity before trying to use internet connection
     */
    private void checkConnectivity() {
        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = null;
        if (cm != null) {
            activeNetwork = cm.getActiveNetworkInfo();
        }
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (!isConnected) {
            String error = getString(R.string.NO_INTERNET_CONNECTION);
            showError(error);
        }
    }

    private void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(LAST_LOCATION_LATITUDE, mLatitude);
        outState.putDouble(LAST_LOCATION_LOGITUDE, mLongitude);
        outState.putParcelable(SAVED_LAYOUT_MANAGER, rvEvents.getLayoutManager().onSaveInstanceState());
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mLayoutManagerSavedState = savedInstanceState.getParcelable(SAVED_LAYOUT_MANAGER);
        mLongitude = savedInstanceState.getDouble(LAST_LOCATION_LOGITUDE);
        mLatitude = savedInstanceState.getDouble(LAST_LOCATION_LATITUDE);
    }

    @Override
    public void onRefresh() {
        checkLocationEnabled();
    }
}


