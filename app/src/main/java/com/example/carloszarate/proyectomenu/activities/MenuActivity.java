package com.example.carloszarate.proyectomenu.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.carloszarate.proyectomenu.R;
import com.example.carloszarate.proyectomenu.adapter.MenuAdapter;
import com.example.carloszarate.proyectomenu.googleAnalytics.AnalyticsApplication;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MenuActivity extends AppCompatActivity {

    GridView gridView;
    String[] name;
    int[] imagen = {R.drawable.desayunos, R.drawable.almuerzo, R.drawable.cena};
    Tracker t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        t = ((AnalyticsApplication) this.getApplication()).getTracker(AnalyticsApplication.TrackerName.APP_TRACKER);
        t.setScreenName("Menu");
        t.send(new HitBuilders.ScreenViewBuilder().build());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Resources res = getResources();
        name = res.getStringArray(R.array.name);

        gridView = (GridView) findViewById(R.id.gridView);

        MenuAdapter adapter = new MenuAdapter(this,imagen,name);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DesayunoActivity.class);
                intent.putExtra("Position",position);

                startActivity(intent);
            }
        });


    }

}
