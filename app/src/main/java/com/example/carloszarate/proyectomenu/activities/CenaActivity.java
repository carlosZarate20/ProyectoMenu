package com.example.carloszarate.proyectomenu.activities;

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

public class CenaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Food> foodList;
    Tracker t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cena);

        t = ((AnalyticsApplication) this.getApplication()).getTracker(AnalyticsApplication.TrackerName.APP_TRACKER);
        t.setScreenName("Cenas");
        t.send(new HitBuilders.ScreenViewBuilder().build());

        recyclerView = (RecyclerView) findViewById(R.id.recView);
        foodList = new ArrayList<>();

        foodList.add(new Food(R.drawable.atunsalteado,"Atun Salteado","S/ 12.00","Incorpora los lomos salteados, el sillao y el vinagre. Cocina durante dos minutos más. Retira del fuego. Esparce el culantro picado y sirve de inmediato."));
        foodList.add(new Food(R.drawable.berenjenassalteadas,"Berenjenas Salteadas","S/ 13.00","Su valor energético y nutritivo es pequeño comparado con otras frutas, verduras y hortalizas. Contiene escasas vitaminas, hidrocarbonos, proteínas y minerales, siendo el componente mayoritario en su peso el agua, en un 92% de su composición"));
        foodList.add(new Food(R.drawable.cogollosgambasajillo,"Cogollos","S/ 10.00","Esta receta de cogollos con gambas al ajillo se prepara en pocos minutos y resulta una ensalada templada sencilla y perfecta para improvisar algo especial."));
        foodList.add(new Food(R.drawable.pollosalteadochampinones,"Pollo Salteado con   Champiñones","S/ 13.00","Esta receta de pollo salteado con champiñones se prepara en pocos minutos y resulta un plato sabroso y ligero, perfecto para improvisar una cena al minuto. En lugar de champiñones puedes usar unas setas a tu gusto"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLiLayoutManager);

        DesayunoAdapter adapter = new DesayunoAdapter(this,foodList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleAnalytics.getInstance(CenaActivity.this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        GoogleAnalytics.getInstance(CenaActivity.this).reportActivityStop(this);
    }
}
