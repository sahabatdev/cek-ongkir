package com.sahabatdeveloper.module.cek_ongkir;

import com.sahabatdeveloper.model.CostResponse;
import com.sahabatdeveloper.rest.ApiClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CekOngkirPresenter {
    CekOngkirView mView;

    public CekOngkirPresenter(CekOngkirView mView) {
        this.mView = mView;
    }

    public void checkHargaKurir(String apiKeyRajaOngkir, String asalCityId, String tujuanCityId, String berat, String kurir) {
        mView.onShowProgress();
        ApiClient.getClient().checkCostCourier(apiKeyRajaOngkir, asalCityId, tujuanCityId, berat, kurir).enqueue(new Callback<CostResponse>() {
            @Override
            public void onResponse(Call<CostResponse> call, Response<CostResponse> response) {
                mView.onHideProgress();
                if(response.isSuccessful()){
                    mView.onSuccessGetOngkir(response.body());
                }else{
                    try {
                        mView.onShowMessage(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<CostResponse> call, Throwable t) {
                mView.onHideProgress();
                mView.onShowMessage("Terjadi kegagalan server");
            }
        });
    }
}
