package com.example.thejepits.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thejepits.R;
import com.example.thejepits.room.ItemModel;
import com.example.thejepits.ui.home.HomeFragment;

import java.util.ArrayList;

public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.ViewHolder> {

    private ArrayList<ItemModel> dataItem;
    private Context context;


    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout parentLayout;
        TextView textJudul, textPengarang, textTahun;
        ImageView imageCover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textJudul = itemView.findViewById(R.id.textJudul);
            textPengarang = itemView.findViewById(R.id.textPengarang);
            textTahun = itemView.findViewById(R.id.textTahun);
            imageCover = itemView.findViewById(R.id.imageCover);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }

    public AdapterRecycleView(Context context, ArrayList<ItemModel> dataItem) {
        this.dataItem = dataItem;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView textJudul = holder.textJudul;
        TextView textPengarang = holder.textPengarang;
        TextView textTahun = holder.textTahun;
        ImageView imageCover = holder.imageCover;

        textJudul.setText(dataItem.get(position).getJudul());
        textPengarang.setText(dataItem.get(position).getPengarang());
        textTahun.setText(dataItem.get(position).getTahun());
        imageCover.setImageResource(dataItem.get(position).getCover());

    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    public void setFilter(ArrayList<ItemModel> filterModel){
        dataItem = new ArrayList<>();
        dataItem.addAll(filterModel);
        notifyDataSetChanged();
    }
}
