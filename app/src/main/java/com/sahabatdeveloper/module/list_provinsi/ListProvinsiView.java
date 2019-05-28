package com.sahabatdeveloper.module.list_provinsi;

import com.sahabatdeveloper.model.CityResponse;

import java.util.List;

public interface ListProvinsiView {
    void onSuccessGetCity(List<CityResponse.Results> listCity);
    void onShowMessage(String message);
    void onShowProgress();
    void onHideProgress();
    void onSelectedCity(String cityId, String nama);
}
