package com.example.carloszarate.proyectomenu.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


;
import com.example.carloszarate.proyectomenu.R;
import com.example.carloszarate.proyectomenu.googleAnalytics.AnalyticsApplication;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity  {

    final static int SPLASH_OUT_TIMEOUT = 3000;
    final static int SLEEP_INTERVAL = 100;
    final static String TAG = "ProyectoMenu";
    Tracker t;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int welcomeScreenDisplay = SPLASH_OUT_TIMEOUT;

        Thread splashThread = new Thread(){
            int wait = 0;
            @Override
            public void run() {
                try {
                    super.run();
                    while(wait < welcomeScreenDisplay) {
                        sleep(SLEEP_INTERVAL);
                        wait += SLEEP_INTERVAL;
                        Log.d(TAG, "Running for " + String.valueOf(wait) + " ms");
                    }

                }catch (Exception e){
                    Log.d(TAG, e.getLocalizedMessage());
                }finally {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                }
            }
        };
        splashThread.start();
        for(int i = 1; i < 10; i++) Log.d(TAG, "Regular instruction");

        /*t = ((AnalyticsApplication) this.getApplication()).getTracker(AnalyticsApplication.TrackerName.APP_TRACKER);
        t.setScreenName("ProyectoMenu");
        t.send(new HitBuilders.ScreenViewBuilder().build());

        boton = findViewById(R.id.buttonIniciar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuOptionsActivity.class);
                startActivity(intent);
                t.send(new HitBuilders.EventBuilder()
                        .setCategory("Clicks")
                        .setAction("Button")
                        .setLabel("clicked")
                        .build());
            }
        });*/
    }



}
