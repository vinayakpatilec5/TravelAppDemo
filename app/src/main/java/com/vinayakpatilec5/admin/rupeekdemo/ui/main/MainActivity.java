package com.vinayakpatilec5.admin.rupeekdemo.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vinayakpatilec5.admin.rupeekdemo.R;
import com.vinayakpatilec5.admin.rupeekdemo.data.MyDataManager;
import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationData;
import com.vinayakpatilec5.admin.rupeekdemo.ui.details.PlaceDetailActivity;

public class MainActivity extends AppCompatActivity implements MainView{

    private MainMvpPresenter presenter;
    private RelativeLayout rvProgress;
    private TextView tvHeader;
    private RecyclerView recyclerView;
    private LocationAdapter locationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        MyDataManager.getInstance().initDb(this);
        presenter = new MainPresenter();
    }

    private void initViews(){
        rvProgress = (RelativeLayout) findViewById(R.id.rv_progress);
        tvHeader = (TextView) findViewById(R.id.tv_header);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onAttach(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onDeAttach();
    }

    @Override
    public void showLoader() {
        rvProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        rvProgress.setVisibility(View.GONE);
    }

    @Override
    public void setCustomerName(String name) {
        tvHeader.setText("Hi "+name);
    }

    @Override
    public void setLocationList() {
        if(locationAdapter == null) {
            locationAdapter = new LocationAdapter(presenter);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(locationAdapter);
        }else {
            locationAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void tappedPlaceDetails(LocationData data) {
        Intent intent = new Intent(this, PlaceDetailActivity.class);
        intent.putExtra("data",data);
        startActivity(intent);
    }

    @Override
    public void onError() {
        tvHeader.setText("NO INTERNET CONNECTION");
        findViewById(R.id.btn_retry).setVisibility(View.VISIBLE);
    }

    public void reloadData(View view){
        tvHeader.setText("Loding data...");
        findViewById(R.id.btn_retry).setVisibility(View.GONE);
        presenter.onAttach(this);
    }
}
