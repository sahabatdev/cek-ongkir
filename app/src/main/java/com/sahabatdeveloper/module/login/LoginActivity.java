package com.sahabatdeveloper.module.login;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sahabatdeveloper.R;
import com.sahabatdeveloper.helper.BaseActivity;
import com.sahabatdeveloper.module.cek_ongkir.CekOngkirActivity;

public class LoginActivity extends BaseActivity implements LoginView{
    private LoginPresenter mPresenter;
    Button btnLogin;
    TextInputLayout layoutUsername, layoutPassword;
    TextInputEditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPresenter = new LoginPresenter(this);

        if(!mPresenter.isExistData())
            mPresenter.insertData();

        layoutUsername = findViewById(R.id.layout_username);
        layoutPassword = findViewById(R.id.layout_password);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etUsername.getText().toString().isEmpty()){
                    layoutUsername.setError("Username harus diisi");
                }else if(etPassword.getText().toString().isEmpty()){
                    layoutPassword.setError("Password harus diisi");
                }else{
                    mPresenter.doLogin(etUsername.getText().toString(),etPassword.getText().toString());
                }
            }
        });

    }

    @Override
    public void onSuccessLogin() {
        startActivity(new Intent(this, CekOngkirActivity.class));
        finish();
    }

    @Override
    public void onShowMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowProgress() {
        showProgress();
    }

    @Override
    public void onHideProgress() {
        hideProgress();
    }
}
