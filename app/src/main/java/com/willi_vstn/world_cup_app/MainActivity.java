package com.willi_vstn.world_cup_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static CustomAdapter adapter;
    ArrayList<CountryModelClass> dataModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //1 AdapterView: a listview
        listView = findViewById(R.id.listView);
        //2 data source
        dataModels = new ArrayList<>();

        dataModels.add(new CountryModelClass("New Zealand", "3", R.drawable.nz));
        dataModels.add(new CountryModelClass("South Africa", "3", R.drawable.sa));
        dataModels.add(new CountryModelClass("Australia", "2", R.drawable.aus));
        dataModels.add(new CountryModelClass("England", "1", R.drawable.eng));

        //3 Adapter
        adapter = new CustomAdapter(dataModels, getApplicationContext());
        listView.setAdapter(adapter);

        //4 Handling the click events on ListView items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Country " + adapter.getItem(i).getCountry_name() +
                        '\n' + "World Cup winds: "+adapter.getItem(i).getCup_win_count(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}