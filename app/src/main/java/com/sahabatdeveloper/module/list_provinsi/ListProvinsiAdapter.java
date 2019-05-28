package com.sahabatdeveloper.module.list_provinsi;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sahabatdeveloper.R;
import com.sahabatdeveloper.model.CityProvinceRealm;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListProvinsiAdapter extends RecyclerView.Adapter<ListProvinsiAdapter.ViewHolder> {
    Context context;
    ListProvinsiView mView;
    List<CityProvinceRealm> listData;
    List<CityProvinceRealm> filterListData;

    public ListProvinsiAdapter(Context context, ListProvinsiView mView, List<CityProvinceRealm> listData) {
        this.context = context;
        this.mView = mView;
        this.listData = listData;
        this.filterListData = new ArrayList<>();
        this.filterListData.addAll(this.listData);
    }

    @NonNull
    @Override
    public ListProvinsiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_provinsi,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ListProvinsiAdapter.ViewHolder holder, int i) {
        final CityProvinceRealm item = filterListData.get(i);

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
        return (null != filterListData ? filterListData.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
        }
    }

    public void filter(final String text) {
        // Searching could be complex..so we will dispatch it to a different thread...
        new Thread(new Runnable() {
            @Override
            public void run() {
                filterListData.clear();

                if (TextUtils.isEmpty(text)) {
                    filterListData.addAll(listData);
                } else {
                    for (CityProvinceRealm item : listData) {
                        if (item.getCity().contains(text) || item.getProvince().contains(text)) {
                            filterListData.add(item);
                        }
                    }
                }

                // Set on UI Thread
                ((Activity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        notifyDataSetChanged();
                    }
                });

            }
        }).start();

    }
}
