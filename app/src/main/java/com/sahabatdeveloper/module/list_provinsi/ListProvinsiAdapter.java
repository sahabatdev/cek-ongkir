package com.sahabatdeveloper.module.list_provinsi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sahabatdeveloper.R;
import com.sahabatdeveloper.model.CityProvinceRealm;

import java.util.List;

public class ListProvinsiAdapter extends RecyclerView.Adapter<ListProvinsiAdapter.ViewHolder> {
    Context context;
    ListProvinsiView mView;
    List<CityProvinceRealm> listData;

    public ListProvinsiAdapter(Context context, ListProvinsiView mView, List<CityProvinceRealm> listData) {
        this.context = context;
        this.mView = mView;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ListProvinsiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_provinsi,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ListProvinsiAdapter.ViewHolder holder, int i) {
        final CityProvinceRealm item = listData.get(i);

        holder.tvNama.setText(item.getCity()+" - "+item.getProvince());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mView.onSelectedCity(item.getCityId(), holder.tvNama.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
        }
    }
}
