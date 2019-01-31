package com.example.braintech.restrofitandroiddemo.requestresponse;

import com.example.braintech.restrofitandroiddemo.moedel.HealthList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    @GET("api/Master/GetHealthAndSafety")
    Call<HealthList> doGetHealth();


}
