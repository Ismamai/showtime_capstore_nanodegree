package com.iblesa.showtime.main;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String apiKey = getString(R.string.ticketmaster_api_key);
    }

    private void loadData(String key) {
        checkConnectivity();
        Retrofit apiClient = ApiClient.getClient();
        ApiService service = apiClient.create(ApiService.class);

        Call<EventResponse> listCall = service.listEvents(key);
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
        loadData(getString(R.string.ticketmaster_api_key));
    }
}


