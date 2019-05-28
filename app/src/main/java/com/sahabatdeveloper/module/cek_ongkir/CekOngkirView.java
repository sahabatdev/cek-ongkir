package com.sahabatdeveloper.module.cek_ongkir;

import com.sahabatdeveloper.model.CostResponse;

public interface CekOngkirView {
    void onSuccessGetOngkir(CostResponse body);
    void onShowProgress();
    void onHideProgress();
    void onShowMessage(String message);
}
