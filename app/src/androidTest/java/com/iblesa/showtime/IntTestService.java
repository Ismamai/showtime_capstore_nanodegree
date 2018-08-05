package com.iblesa.showtime;

import com.iblesa.api.ApiClient;
import com.iblesa.api.ApiService;
import com.iblesa.api.models.EventResponse;

import org.junit.Test;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IntTestService {

//    @Test
//    public void testService() throws IOException {
//        Retrofit apiClient = ApiClient.getClient();
//        ApiService service = apiClient.create(ApiService.class);
//
//        Call<EventResponse> listCall = service.listEvents("YouWish :D");
//        Response<EventResponse> execute = listCall.execute();
//        if (execute.isSuccessful()) {
//            EventResponse body = execute.body();
//
//            int size = body.getEmbedded().getEvents().size();
//        }
//
//    }
}
