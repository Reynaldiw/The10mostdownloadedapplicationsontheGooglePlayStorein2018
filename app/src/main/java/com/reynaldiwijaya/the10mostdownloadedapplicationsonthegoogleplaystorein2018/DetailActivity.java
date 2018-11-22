package com.reynaldiwijaya.the10mostdownloadedapplicationsonthegoogleplaystorein2018;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.imgAppDetail)
    ImageView imgAppDetail;
    @BindView(R.id.txtTitleAppDetail)
    TextView txtTitleAppDetail;
    @BindView(R.id.txtDetail)
    TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        txtTitleAppDetail.setText(getIntent().getStringExtra("namaApp"));
        txtDetail.setText(getIntent().getStringExtra("detailApp"));
        Glide.with(this).load(getIntent().getIntExtra("gambarApp", 0)).into(imgAppDetail);
    }
}
