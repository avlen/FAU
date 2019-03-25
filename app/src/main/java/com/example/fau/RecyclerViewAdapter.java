package com.example.fau;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.MyHolder>{

    String nama [] = {"Takoyaki"};
    int gambar [] = {R.drawable.takoyaki};
    String detail [] = {"Kedai kecil Takoyaki terletak disamping Alfamart"};

    Context context;
    LayoutInflater layoutInflater;

    public RecyclerViewAdapter (Context context ){

        this.context = context;
        layoutInflater = layoutInflater.from(context);

    }
    @Override
    public RecyclerViewAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyHolder holder, final int position) {

        // ini berfungsi untuk mengirim data ke DetailActivity
        holder.txt.setText(nama [position]);
        holder.img.setImageResource(gambar [position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kirimData = new Intent(context, DetailActivity.class);
                kirimData.putExtra("Nama", nama [position]);
                kirimData.putExtra("IMG", gambar [position]);
                kirimData.putExtra("DET", detail [position]);

                context.startActivity(kirimData);

            }
        });
    }

    @Override
    public int getItemCount() {
        return nama.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        // ID ini diambil dari file list_item.xml
        ImageView img;
        TextView txt;

        public MyHolder(View itemView) {

            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imglist);
            txt = (TextView) itemView.findViewById(R.id.txtlist);
        }
    }
}