package com.vinayakpatilec5.admin.rupeekdemo.ui.main;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.vinayakpatilec5.admin.rupeekdemo.R;
import com.vinayakpatilec5.admin.rupeekdemo.data.network.model.LocationData;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.MyViewHolder> {

    private MainMvpPresenter presenter;
    public LocationAdapter(MainMvpPresenter presenter) {
        this.presenter = presenter;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvDesc, tvDate;
        public ImageView ivPlace,ivFavourite;
        private View cvMain;

        public MyViewHolder(View view) {
            super(view);
            tvDate = (TextView) view.findViewById(R.id.tv_date);
            tvDesc = (TextView) view.findViewById(R.id.tv_desc);
            ivPlace = (ImageView) view.findViewById(R.id.iv_place);
            ivFavourite = (ImageView) view.findViewById(R.id. iv_favourite);
            cvMain = view.findViewById(R.id.cv_main);
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        LocationData locationData = presenter.getLocationData(position);
        holder.tvDesc.setText(locationData.getPlace());
        holder.tvDate.setText(locationData.getDate());
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.default_bg).error(R.drawable.default_bg).error(R.drawable.default_bg);
        Glide.with(holder.ivPlace.getContext()).load(locationData.getUrl()).apply(requestOptions).into(holder.ivPlace);
        holder.ivFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.ivFavourite.isSelected()) {
                    holder.ivFavourite.setImageResource(R.drawable.ic_favorite_border);
                    holder.ivFavourite.setSelected(false);
                }else {
                    holder.ivFavourite.setImageResource(R.drawable.ic_favorite);
                    holder.ivFavourite.setSelected(true);
                }
            }
        });
        holder.cvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.tappedPlaceDetails(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return presenter.getLocationsCount();
    }
}