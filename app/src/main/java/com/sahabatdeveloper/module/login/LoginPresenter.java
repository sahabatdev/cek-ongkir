package com.sahabatdeveloper.module.login;

import android.support.v7.widget.LinearLayoutManager;

import com.sahabatdeveloper.model.CityProvinceRealm;
import com.sahabatdeveloper.model.CityResponse;
import com.sahabatdeveloper.model.LoginRealm;
import com.sahabatdeveloper.module.list_provinsi.ListProvinsiActivity;
import com.sahabatdeveloper.module.list_provinsi.ListProvinsiAdapter;

import java.util.ArrayList;
import java.util.List;

import io.realm.Case;
import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmResults;

public class LoginPresenter {
    LoginView mView;
    private Realm mRealm;

    public LoginPresenter(LoginView mView) {
        this.mView = mView;
        mRealm = Realm.getDefaultInstance();
    }

    public void insertData() {
        Realm realm = Realm.getDefaultInstance();
            final LoginRealm loginRealm = new LoginRealm();
            loginRealm.setId(1);
            loginRealm.setUsername("maulana");
            loginRealm.setPassword("maulana");
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.insert(loginRealm);
                }
            });
    }

    public void doLogin(final String username, final String password){
        mView.onShowProgress();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mView.onHideProgress();
                LoginRealm results = realm.where(LoginRealm.class).equalTo("username",username).and().equalTo("password",password).findFirst();
                if(results!=null)
                    mView.onSuccessLogin();
                else
                    mView.onShowMessage("Username atau Password Salah");
            }
        });
    }

    public boolean isExistData(){
        RealmResults<LoginRealm> results = mRealm.where(LoginRealm.class).findAll();
        if(results!=null && results.size()!=0){
            return true;
        }
        return false;
    }
}
