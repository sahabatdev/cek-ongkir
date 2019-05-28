package com.sahabatdeveloper.module.list_provinsi;

import com.sahabatdeveloper.model.CityResponse;
import com.sahabatdeveloper.rest.ApiClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListProvinsiPresenter {
    ListProvinsiView mView;

    public ListProvinsiPresenter(ListProvinsiView mView) {
        this.mView = mView;
    }

    public void getDataCity(String key){
        mView.onShowProgress();
        ApiClient.getClient().getCity(key).enqueue(new Callback<CityResponse>() {
            @Override
            public void onResponse(Call<CityResponse> call, Response<CityResponse> response) {
                mView.onHideProgress();
                if(response.isSuccessful()){
                    mView.onSuccessGetCity(response.body().getRajaongkir().getResults());
                }else{
                    try {
                        mView.onShowMessage(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<CityResponse> call, Throwable t) {
                mView.onHideProgress();
                mView.onShowMessage("Terjadi kegagalan server");
            }
        });
    }

}
