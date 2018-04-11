package com.example.carloszarate.proyectomenu.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.carloszarate.proyectomenu.R;
import com.example.carloszarate.proyectomenu.adapter.AlmuerzoAdapter;
import com.example.carloszarate.proyectomenu.adapter.DesayunoAdapter;
import com.example.carloszarate.proyectomenu.googleAnalytics.AnalyticsApplication;
import com.example.carloszarate.proyectomenu.model.Food;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;

public class AlmuerzoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Food> foodList;
    Tracker t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almuerzo);

        t = ((AnalyticsApplication) this.getApplication()).getTracker(AnalyticsApplication.TrackerName.APP_TRACKER);
        t.setScreenName("Almuerzo");
        t.send(new HitBuilders.ScreenViewBuilder().build());

        recyclerView = (RecyclerView) findViewById(R.id.recView);
        foodList = new ArrayList<>();

        foodList.add(new Food(R.drawable.ajidegallina,"Aji de Gallina","S/ 12.00","El ají de gallina es uno de los platos más deliciosos de la cocina peruana. Se trata de un plato muy sencillo, que combina arroz y pollo, de una forma un tanto particular: la salsa, característica de este plato, envuelve los trozos de pollo deshilachado y le otorga un sabor delicioso"));
        foodList.add(new Food(R.drawable.arrozchaufa,"Arroz Chaufa","S/ 10.00","El arroz frito (en chino simplificado: 炒饭, chino tradicional: 炒飯, pinyin: chǎofàn) es un plato de la cocina china"));
        foodList.add(new Food(R.drawable.arrozpollo,"Arroz con Pollo","S/ 13.00","Este tradicional plato de la costa de nuestro país consiste en arroz cocinado y encima se le coloca su presa de pollo, lleva un perfecto equilibrio entre los ingredientes como la cebolla, choclo, arverja, el pimiento, zanahoria en cuadraditos y sazonado con culantro, ajo, pimienta, sal al gusto, todo esto con un recién graneado arroz"));
        foodList.add(new Food(R.drawable.bistecmarino,"Bistec Marino","S/ 13.00","Este bistec se encuentra en la parte pierna. Tiene forma rectangular, es el bistec que tiene menos grasa y nervio. Este bistec lo puedes también utilizar para un lomo saltado y bistec apanado"));
        foodList.add(new Food(R.drawable.ceviche,"Ceviche","S/ 15.00","l clásico o tradicional de la región costera, en su preparación se emplea de pescado tiburón o sierra, cortado en cubitos que son adobados en jugo de limón, cebolla colorada cortada en anillos y marinada en jugo de limón con sal, y cilantro picado, y se sazona con sal y pimienta"));
        foodList.add(new Food(R.drawable.lomosaltado,"Lomo Saltado","S/ 15.00","Carne de res, sal, pimienta, comino, cebolla, ajo, ají amarillo, vinagre tinto o blanco, tomate, perejil, papas, aceite. A veces sillao y un chorrito de pisco"));
        foodList.add(new Food(R.drawable.tallarines,"Tallarines Rojos","S/ 15.00","Tal vez los tallarines rojos sean el mejor ejemplo de la fusión entre la gastronomía peruana y la italiana. Este sabroso platillo no es otra cosa que la versión peruana de los espaguetis con ragú"));

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
        GoogleAnalytics.getInstance(AlmuerzoActivity.this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        GoogleAnalytics.getInstance(AlmuerzoActivity.this).reportActivityStop(this);
    }
}
