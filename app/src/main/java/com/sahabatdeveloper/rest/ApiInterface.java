package com.sahabatdeveloper.rest;

import com.sahabatdeveloper.model.CityResponse;
import com.sahabatdeveloper.model.CostResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * @Author SahabatDeveloper
 *
 */
public interface ApiInterface {
    // Get Province
    @GET("city")
    Call<CityResponse> getCity(@Header("key") String key);

    @FormUrlEncoded
    @POST("cost")
    Call<CostResponse> checkCostCourier(@Header("key") String key, @Field("origin") String origin, @Field("destination") String destination, @Field("weight") String weight, @Field("courier") String courier);
}
