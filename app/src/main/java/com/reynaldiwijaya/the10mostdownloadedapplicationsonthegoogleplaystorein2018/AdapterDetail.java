package com.reynaldiwijaya.the10mostdownloadedapplicationsonthegoogleplaystorein2018;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterDetail extends RecyclerView.Adapter<AdapterDetail.ViewHolder> {
    DetailFragment context;
    String[] namaApp, detailApp;
    int [] gambarApp;

    public AdapterDetail(DetailFragment context, String[] namaApp, String[] detailApp, int[] gambarApp) {
        this.context = context;
        this.namaApp = namaApp;
        this.detailApp = detailApp;
        this.gambarApp = gambarApp;
    }

    @NonNull
    @Override
    public AdapterDetail.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_app, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDetail.ViewHolder viewHolder, final int i) {
        viewHolder.txtTitleApp.setText(namaApp[i]);
        Glide.with(context).load(gambarApp[i]).into(viewHolder.imgApp);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(v.getContext(), DetailActivity.class);
                pindah.putExtra("namaApp", namaApp[i]);
                pindah.putExtra("gambarApp", gambarApp[i]);
                pindah.putExtra("detailApp", detailApp[i]);
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambarApp.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitleApp;
        ImageView imgApp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitleApp = itemView.findViewById(R.id.txtTitleApp);
            imgApp = itemView.findViewById(R.id.imgApp);
        }
    }
}
