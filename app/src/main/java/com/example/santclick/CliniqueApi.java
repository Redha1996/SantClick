package com.example.santclick;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CliniqueApi {
    @GET("CliniqueApi.json")
    Call<RestCliniqueResponse> getCliniqueResponse();
}
