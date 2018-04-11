package com.example.carloszarate.proyectomenu.googleAnalytics;

import android.app.Application;

import com.example.carloszarate.proyectomenu.R;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import java.util.HashMap;

public class AnalyticsApplication extends Application {

    private static final String PROPERTY_ID = "UA-116791804-2";

    public static int GENERAL_TRACKER = 0;

    public enum TrackerName{
        APP_TRACKER, //Tracker usado solo para esta app
        GLOBAL_TRACKER, //Tracker usado por todas las apps de la compañia
        ECOMMERCE_TRACKER, // Traceker usado por todas las transaciones de comercio electronico de la compañia
    }

    public HashMap<TrackerName,Tracker> mTrackers = new HashMap<TrackerName,Tracker>();
    public AnalyticsApplication(){ super(); }

    public synchronized Tracker getTracker(TrackerName trackerId) {
        if (!mTrackers.containsKey(trackerId)) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            Tracker t =
                    (trackerId == TrackerName.APP_TRACKER) ? analytics.newTracker(PROPERTY_ID):
                            (trackerId == TrackerName.GLOBAL_TRACKER) ?
                                    analytics.newTracker(R.xml.global_tracker):
                                    analytics.newTracker(R.xml.global_tracker);
            mTrackers.put(trackerId,t);
        }
        return mTrackers.get(trackerId);
    }

}
