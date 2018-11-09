package com.example.maulana.xinhua.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.maulana.xinhua.R;

import com.example.maulana.xinhua.Modul.ArticlesItem;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<ArticlesItem> articlesItems;
    Context context;

    public MyAdapter(List<ArticlesItem> dataItemsct, Context contextct) {
        articlesItems = dataItemsct;
        context = contextct;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list, viewGroup, false);
        return new MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
        myViewHolder.tv_nama.setText(articlesItems.get(i).getAuthor());
        myViewHolder.tv_wilayah.setText(Html.fromHtml(articlesItems.get(i).getTitle()));
        Glide.with(context)
                .load(articlesItems.get(i).getUrlToImage())
                .into(myViewHolder.tv_phone);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                context.startActivity( new Intent(context, DetailActivity.class)
//                        .putExtra("nama", articlesItems.get(i).getNama())
//                        .putExtra("phone", articlesItems.get(i).getPhone())
//                        .putExtra("wilayah", articlesItems.get(i).getWilayah())
//                        .putExtra("alamat", articlesItems.get(i).getAlamat())
//                        .putExtra("jabatan", articlesItems.get(i).getJabatan())
//                        .putExtra("login", articlesItems.get(i).getLoginTerakhir()));

            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_nama, tv_wilayah;
        public ImageView tv_phone;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_nama = itemView.findViewById(R.id.author);
            tv_wilayah = itemView.findViewById(R.id.tittle);
            tv_phone = itemView.findViewById(R.id.img);
        }
    }
}
