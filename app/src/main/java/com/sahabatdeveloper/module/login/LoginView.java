package com.sahabatdeveloper.module.login;

public interface LoginView {
    void onSuccessLogin();
    void onShowMessage(String message);
    void onShowProgress();
    void onHideProgress();
}
