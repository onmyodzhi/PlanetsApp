package com.example.planetsapp;

import android.content.Context;
import android.service.controls.templates.ControlTemplate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> arrayListOfPlanet;
    public MyCustomAdapter(@NonNull Context context, ArrayList<Planet> arrayListOfPlanet) {
        super(context, R.layout.item_list_layout, arrayListOfPlanet);
        this.arrayListOfPlanet = arrayListOfPlanet;

    }

    private static class MyViewHolder {
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planets  = getItem(position);

        MyViewHolder myViewHolder;
        final View result;

        if (convertView == null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );
            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.planetName);
            myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.moon);
            myViewHolder.planetImg = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;

            convertView.setTag(myViewHolder);
        }else {
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        myViewHolder.planetName.setText(planets.getPlanetName());
        myViewHolder.moonCount.setText(planets.getMoonCount());
        myViewHolder.planetImg.setImageResource(planets.getPlanetImage());

        return result;
    }

    
}
