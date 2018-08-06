package com.iblesa.showtime.main;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.iblesa.api.ApiClient;
import com.iblesa.api.ApiService;
import com.iblesa.api.models.EventResponse;
import com.iblesa.showtime.Constants;
import com.iblesa.showtime.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_ACCESS_COARSE_LOCATION = 1234;
    private static final String LAST_LOCATION_LATITUDE = "LATITUDE";
    private static final String LAST_LOCATION_LOGITUDE = "LONGITUDE";
    private static boolean locationEnabled = false;
    private FusedLocationProviderClient mFusedLocationClient;

    private double mLatitude = Constants.DEFAULT_LOCATION_LAT;
    private double mLongitude = Constants.DEFAULT_LOCATION_LON;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String apiKey = getString(R.string.ticketmaster_api_key);
        checkLocationEnabled();

    }

    private void checkLocationEnabled() {
        //Check if we have already permission for location
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    PERMISSION_ACCESS_COARSE_LOCATION);
        }
//        new GoogleApiClient.Builder(this,this,)
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
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
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_ACCESS_COARSE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Location granted
                    locationEnabled = true;
                } else {
                    Toast.makeText(this, R.string.LOCATION_IS_REQUIRED, Toast.LENGTH_LONG).show();
                }
        }
    }

    private void loadData(String key) {
        checkConnectivity();
        Retrofit apiClient = ApiClient.getClient();
        ApiService service = apiClient.create(ApiService.class);
        String latlong = mLatitude + "," + mLongitude;
        Call<EventResponse> listCall = service.listEvents(key, latlong);
        listCall.enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                EventResponse eventResponse = response.body();
                int size = 0;

                List<com.iblesa.api.models.Event> events = eventResponse.getEmbedded().getEvents();
                if (eventResponse != null && events != null) {
                    size = events.size();
                }
                String message = String.format("Setting events (%s) %s", size, events);
                Log.d(Constants.TAG, message);

//                mEventsListAdapter.setRecipes(eventResponse);

            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                String error = getString(R.string.ERROR_LOADING_DATA);
                showError(error);
            }
        });
    }

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
    }
}


