package com.vinayakpatilec5.admin.rupeekdemo.ui.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.vinayakpatilec5.admin.rupeekdemo.R;
import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationData;
import com.vinayakpatilec5.admin.rupeekdemo.ui.main.MainPresenter;

public class PlaceDetailActivity extends AppCompatActivity implements PlaceDetailView {

    private PlaceDetailMvpPresenter presenter = new PlaceDetailPresenter();

    private TextView tvName, tvDesc, tvDate, tvPrice;
    private ImageView ivPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);
        LocationData locationData = (LocationData)getIntent().getSerializableExtra("data");
        presenter.setLocationData(locationData);
        intiViews();
        presenter.onAttach(this);
    }

    public void tappedBackButton(View view){
        this.finish();
    }

    private void intiViews(){
        tvName = (TextView) findViewById(R.id.tv_name);
        tvDate = (TextView) findViewById(R.id.tv_date);
        tvDesc = (TextView) findViewById(R.id.tv_desc);
        ivPlace = (ImageView) findViewById(R.id.iv_place);
        tvPrice = (TextView) findViewById(R.id.tv_price);
    }

    @Override
    public void setDateData(String date) {
        tvDate.setText(date);
    }

    @Override
    public void setPlaceName(String name) {
        tvName.setText(name);
    }

    @Override
    public void setPlaceImage(String url) {
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.default_bg).error(R.drawable.default_bg).error(R.drawable.default_bg);
        Glide.with(this).load(url).apply(requestOptions).into(ivPlace);
    }

    @Override
    public void setDesc(String desc) {
        tvDesc.setText(desc);
    }

    @Override
    public void setPrice(String priceStr) {
        tvPrice.setText(priceStr);
    }
}
