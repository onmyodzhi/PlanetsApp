package com.example.planetsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Planet> planetsArrayList;
    private static MyCustomAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        planetsArrayList = new ArrayList<>();

        Planet mercury = new Planet("Mercury", "0", R.drawable.mer);
        planetsArrayList.add(mercury);

        Planet venera = new Planet("Venera", "0", R.drawable.venera);
        planetsArrayList.add(venera);

        Planet earth = new Planet("Earth", "1", R.drawable.earth);
        planetsArrayList.add(earth);

        Planet mars = new Planet("Mars", "2", R.drawable.mars);
        planetsArrayList.add(mars);

        Planet jupiter = new Planet("Jupiter", "79", R.drawable.jupiter);
        planetsArrayList.add(jupiter);

        Planet saturn = new Planet("Saturn", "146", R.drawable.saturn);
        planetsArrayList.add(saturn);

        Planet uranus = new Planet("Uranus", "27", R.drawable.uran);
        planetsArrayList.add(uranus);

        Planet neptune = new Planet("Neptune", "14", R.drawable.nept);
        planetsArrayList.add(neptune);



        adapter = new MyCustomAdapter(getApplicationContext(), planetsArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Planet Name: " + adapter.getItem(position).getPlanetName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}