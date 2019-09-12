package com.example.myappsql;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<Data> dataList;

    public DataAdapter(List<Data> dataList){
        this.dataList = dataList;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list_item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Data data = dataList.get(position);
        holder.textdata.setText(data.getText());
        holder.img.setImageResource(data.getImage());

    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textdata;
        public ImageView img;

        public ViewHolder(View v) {
            super(v);

            textdata = (TextView) v.findViewById(R.id.txtData);
            img = (ImageView) v.findViewById(R.id.image);

        }
    }
}


