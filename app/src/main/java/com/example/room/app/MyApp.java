package com.example.room.app;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        if (BuildConfig.DEBUG) {
////            Stetho.initialize(
////                    Stetho.newInitializerBuilder(this)
////                            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
////                            .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
////                            .build()
////            );
//        }
        Stetho.initializeWithDefaults(this);
    }
}
