package com.ysl.mymvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ysl.mymvp.R;

import java.util.ArrayList;

/**
 * Created by ysl on 2017/11/7.
 */

public class RecycleAdapter extends Adapter<RecycleAdapter.RecycleHoler> {

    private Context context;
    private ArrayList<String> list;

    public RecycleAdapter(Context context, ArrayList<String> list) {

        this.context = context;
        this.list = list;
    }

    @Override
    public RecycleHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycle_item, parent, false);

        RecycleHoler holer = new RecycleHoler(itemView);
        return holer;
    }

    @Override
    public void onBindViewHolder(RecycleHoler holder, int position) {

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

     class RecycleHoler extends RecyclerView.ViewHolder {

        public RecycleHoler(View itemView) {
            super(itemView);

        }
    }
}
