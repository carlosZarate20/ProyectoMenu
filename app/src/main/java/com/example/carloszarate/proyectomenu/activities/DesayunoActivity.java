package com.example.carloszarate.proyectomenu.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.carloszarate.proyectomenu.R;
import com.example.carloszarate.proyectomenu.adapter.DesayunoAdapter;
import com.example.carloszarate.proyectomenu.googleAnalytics.AnalyticsApplication;
import com.example.carloszarate.proyectomenu.model.Food;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;

public class DesayunoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Food> foodList;
    Tracker t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desayuno);

        t = ((AnalyticsApplication) this.getApplication()).getTracker(AnalyticsApplication.TrackerName.APP_TRACKER);
        t.setScreenName("Desayunos");
        t.send(new HitBuilders.ScreenViewBuilder().build());


        recyclerView = (RecyclerView) findViewById(R.id.recView);
        foodList = new ArrayList<>();

        foodList.add(new Food(R.drawable.cafe,"Cafe","S/ 2.00","Cafe preparado con leche y azucar"));
        foodList.add(new Food(R.drawable.cereal,"Cereal","S/ 6.00","Cereal con leche y fruta: Las principales especies de cereales son el maíz, el trigo, la avena, el arroz, el centeno, la cebada, el sorgo y el mijo, entre otras"));
        foodList.add(new Food(R.drawable.pan,"Pan","S/ 2.00","Pan para acompañar con un buen jugo, bajo en calorias y 100% organico"));
        foodList.add(new Food(R.drawable.tostada,"Tostada","S/ 3.00","Una tostada es una rebanada de pan tostado. Según el país se lo puede llamar de diversas maneras y estas pueden ser diferentes. El color amarronado que toma la tostada se debe a la Reacción de Maillard"));
        foodList.add(new Food(R.drawable.yogurt,"Yogurt","S/ 3.50","Yogurt de fresa y sin azucar, para una mañana nutritiva"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLiLayoutManager);

        DesayunoAdapter adapter = new DesayunoAdapter(this,foodList);
        recyclerView.setAdapter(adapter);

    }
    private void setUpActionBar()
    {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        GoogleAnalytics.getInstance(DesayunoActivity.this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        GoogleAnalytics.getInstance(DesayunoActivity.this).reportActivityStop(this);
    }
}
