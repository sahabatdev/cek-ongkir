package com.sahabatdeveloper.module.list_provinsi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.sahabatdeveloper.R;
import com.sahabatdeveloper.config.AppConfig;
import com.sahabatdeveloper.helper.BaseActivity;
import com.sahabatdeveloper.model.CityProvinceRealm;
import com.sahabatdeveloper.model.CityResponse;

import java.util.ArrayList;
import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmResults;

public class ListProvinsiActivity extends BaseActivity implements ListProvinsiView {
    ListProvinsiPresenter mPresenter;
    EditText etSearchProvinsi;
    RecyclerView rvListProvinsi;
    private Realm mRealm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_provinsi);

        mPresenter = new ListProvinsiPresenter(this);
        etSearchProvinsi = findViewById(R.id.et_search_provinsi);
        rvListProvinsi = findViewById(R.id.rv_list_provinsi);

        mRealm = Realm.getDefaultInstance();

        if(!isExistData())
            mPresenter.getDataCity(AppConfig.API_KEY_RAJA_ONGKIR);
        else
            showData();

        etSearchProvinsi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filterData(editable.toString());
            }
        });
    }

    private void showData(){
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<CityProvinceRealm> results = realm.where(CityProvinceRealm.class).findAll();
                rvListProvinsi.setLayoutManager(new LinearLayoutManager(ListProvinsiActivity.this));
                rvListProvinsi.setHasFixedSize(true);
                List<CityProvinceRealm> listData = new ArrayList<>();
                listData.addAll(results);
                rvListProvinsi.setAdapter(new ListProvinsiAdapter(ListProvinsiActivity.this,ListProvinsiActivity.this,listData));
            }
        });
    }

    private void filterData(final String filter){
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<CityProvinceRealm> results = realm.where(CityProvinceRealm.class).contains("city",filter, Case.INSENSITIVE).or().contains("province",filter, Case.INSENSITIVE).findAll();
                rvListProvinsi.setLayoutManager(new LinearLayoutManager(ListProvinsiActivity.this));
                rvListProvinsi.setHasFixedSize(true);
                List<CityProvinceRealm> listData = new ArrayList<>();
                listData.addAll(results);
                rvListProvinsi.setAdapter(new ListProvinsiAdapter(ListProvinsiActivity.this,ListProvinsiActivity.this,listData));
            }
        });
    }



    private boolean isExistData(){
        RealmResults<CityProvinceRealm> results = mRealm.where(CityProvinceRealm.class).findAll();
        if(results!=null && results.size()!=0){
            return true;
        }
        return false;
    }



    @Override
    public void onSuccessGetCity(List<CityResponse.Results> listCity) {
        insertData(listCity);
        showData();
    }

    private void insertData(List<CityResponse.Results> listCity) {
        Realm realm = Realm.getDefaultInstance();
        for (CityResponse.Results results : listCity) {
            final CityProvinceRealm cityProvinceRealm = new CityProvinceRealm();
            cityProvinceRealm.setProvince(results.getProvince());
            cityProvinceRealm.setCity(results.getCity_name());
            cityProvinceRealm.setCityId(results.getCity_id());
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.insert(cityProvinceRealm);
                }
            });
        }
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

    @Override
    public void onSelectedCity(String cityId, String nama) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("nama",nama);
        returnIntent.putExtra("cityId",cityId);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
