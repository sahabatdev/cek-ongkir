package com.sahabatdeveloper.module.cek_ongkir;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sahabatdeveloper.R;
import com.sahabatdeveloper.config.AppConfig;
import com.sahabatdeveloper.helper.BaseActivity;
import com.sahabatdeveloper.model.CostResponse;
import com.sahabatdeveloper.module.list_provinsi.ListProvinsiActivity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CekOngkirActivity extends BaseActivity implements CekOngkirView{
    private static final int REQUEST_CODE_ASAL = 1;
    private static final int REQUEST_CODE_TUJUAN = 2;
    private CekOngkirPresenter mPresenter;
    private EditText etKotaAsal, etKotaTujuan, etBeratBarang;
    private TextView tvHasil;
    private Spinner spnPilihKurir;
    private String asalCityId=null, tujuanCityId=null;
    private Button btnCek;
    private String[] dataKurir = {"jne","pos","tiki"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_ongkir);

        mPresenter = new CekOngkirPresenter(this);
        etKotaAsal = findViewById(R.id.et_kota_asal);
        etKotaTujuan = findViewById(R.id.et_kota_tujuan);
        etBeratBarang = findViewById(R.id.et_berat_barang);
        spnPilihKurir = findViewById(R.id.spn_pilih_kurir);
        btnCek = findViewById(R.id.btn_cek);
        tvHasil = findViewById(R.id.tv_hasil);

        spnPilihKurir.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataKurir));

        etKotaAsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CekOngkirActivity.this, ListProvinsiActivity.class);
                startActivityForResult(i, REQUEST_CODE_ASAL);
            }
        });

        etKotaTujuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CekOngkirActivity.this, ListProvinsiActivity.class);
                startActivityForResult(i, REQUEST_CODE_TUJUAN);
            }
        });

        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (asalCityId == null)
                    onShowMessage("Harap memilih Kota Asal");
                else if(tujuanCityId == null)
                    onShowMessage("Harap memilih Kota Asal");
                else if(etBeratBarang.getText().toString().isEmpty())
                    onShowMessage("Harap masukkan berat barang");
                else
                    mPresenter.checkHargaKurir(AppConfig.API_KEY_RAJA_ONGKIR,asalCityId,tujuanCityId,etBeratBarang.getText().toString(),spnPilihKurir.getSelectedItem().toString());
            }
        });

    }

    static DecimalFormat df= new DecimalFormat("#,##0");
    public static String convertRupiah(int nominal){
        df.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ITALY));
        return df.format(Double.valueOf(nominal));
    }

    @Override
    public void onSuccessGetOngkir(CostResponse body) {
        tvHasil.setText(
                "Kota Asal : "+body.getRajaongkir().getOrigin_details().getCity_name()+" - "+body.getRajaongkir().getOrigin_details().getProvince()+
                "\nKota Tujuan : "+body.getRajaongkir().getDestination_details().getCity_name()+" - "+body.getRajaongkir().getDestination_details().getProvince()+
                "\nBerat : "+body.getRajaongkir().getQuery().getWeight()+" Gram"+
                "\nKurir : "+body.getRajaongkir().getResults().get(0).getName()
        );

        String tipePengiriman = "\n\nService\n\n";
        for (CostResponse.Costs cost : body.getRajaongkir().getResults().get(0).getCosts()) {
            tipePengiriman+=cost.getService() +" | "+cost.getCost().get(0).getEtd()+" | Rp"+convertRupiah(cost.getCost().get(0).getValue())+"\n";
        }

        tvHasil.append(tipePengiriman);
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
    public void onShowMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ASAL && resultCode == Activity.RESULT_OK){
            asalCityId = data.getStringExtra("cityId");
            etKotaAsal.setText(data.getStringExtra("nama"));
        }else if (requestCode == REQUEST_CODE_TUJUAN &&resultCode == Activity.RESULT_OK){
            tujuanCityId = data.getStringExtra("cityId");
            etKotaTujuan.setText(data.getStringExtra("nama"));
        }
    }
}
