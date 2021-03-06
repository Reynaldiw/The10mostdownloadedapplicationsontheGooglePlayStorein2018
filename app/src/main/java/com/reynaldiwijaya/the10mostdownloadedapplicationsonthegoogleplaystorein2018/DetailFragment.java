package com.reynaldiwijaya.the10mostdownloadedapplicationsonthegoogleplaystorein2018;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    String[] namaApp, detailApp;
    int[] gambarApp;


    @BindView(R.id.myRecyclerview)
    RecyclerView myRecyclerview;
    Unbinder unbinder;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        namaApp = getResources().getStringArray(R.array.app_name);
        detailApp = getResources().getStringArray(R.array.app_detail);
        gambarApp = new int[]{R.drawable.wa, R.drawable.ml,R.drawable.tiktok,R.drawable.fblite, R.drawable.messenger,R.drawable.shareit,R.drawable.ig, R.drawable.youtube,R.drawable.uc,R.drawable.grab};

        AdapterDetail adapterApp = new AdapterDetail(DetailFragment.this, namaApp, detailApp, gambarApp);

        myRecyclerview.setHasFixedSize(true);
        myRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        myRecyclerview.setAdapter(adapterApp);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
