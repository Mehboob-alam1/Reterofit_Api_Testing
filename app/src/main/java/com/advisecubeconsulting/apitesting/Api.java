package com.advisecubeconsulting.apitesting;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("posts")
    Call<List<Model>> getdata();
}
