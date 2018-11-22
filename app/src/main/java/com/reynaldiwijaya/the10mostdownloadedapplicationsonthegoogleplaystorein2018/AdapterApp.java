package com.reynaldiwijaya.the10mostdownloadedapplicationsonthegoogleplaystorein2018;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterApp extends RecyclerView.Adapter<AdapterApp.ViewHolder> {
    RecyclerFragment context;
    String[] namaApp, detailApp;
    int [] gambarApp;

    public AdapterApp(RecyclerFragment context, String[] namaApp, String[] detailApp, int[] gambarApp) {
        this.context = context;
        this.namaApp = namaApp;
        this.detailApp = detailApp;
        this.gambarApp = gambarApp;
    }


    @NonNull
    @Override
    public AdapterApp.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_app, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterApp.ViewHolder viewHolder, final int i) {
        viewHolder.txtTitleApp.setText(namaApp[i]);
        Glide.with(context).load(gambarApp[i]).into(viewHolder.imgApp);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Uri uri = Uri.parse("market://search?q=" + namaApp[i]);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    context.startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Uri uri1 = Uri.parse("http://play.google.com/store/search?q=" + namaApp[i]);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri1);
                    context.startActivity(intent);
                }
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
