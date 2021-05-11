package com.example.android.sunshine;

import android.content.Context;
import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    private String[] mWeatherData;

    ForecastAdapter(){

    }

    @NonNull
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context =viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.forecast_list_item, viewGroup, false);

        return new ForecastAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastAdapterViewHolder forecastAdapterViewHolder, int position) {
        String weatherForThisDay = mWeatherData[position];
        forecastAdapterViewHolder.mWeatherTextView.setText(weatherForThisDay);
    }

    @Override
    public int getItemCount() {
        if (mWeatherData == null)
            return 0;

        return mWeatherData.length;
    }

    public void setWeatherData(String[] mWeatherData) {
        this.mWeatherData = mWeatherData;
        notifyDataSetChanged();
    }

    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder{
        final TextView mWeatherTextView;

        ForecastAdapterViewHolder(View itemView){
            super(itemView);
            mWeatherTextView = itemView.findViewById(R.id.tv_weather_data);
        }

    }
}
