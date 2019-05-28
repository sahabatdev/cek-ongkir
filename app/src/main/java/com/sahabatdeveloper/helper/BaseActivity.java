package com.sahabatdeveloper.helper;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sahabatdeveloper.R;

public class BaseActivity extends AppCompatActivity {
    ProgressDialog pDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage(getString(R.string.label_loading));
        pDialog.setCanceledOnTouchOutside(false);
    }

    public void showProgress(){
        pDialog.show();
    }

    public void hideProgress(){
        pDialog.hide();
    }


}
