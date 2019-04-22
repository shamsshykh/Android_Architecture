package com.example.room.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class AppApplication extends Application {

    private static final String TAG = AppApplication.class.getSimpleName();

    public static final String PREFERENCES_KEY = "COM.SANA.POS";

    private static final String API_TOKEN = "api_token";
    private static final String FCM_TOKEN = "fcm_token";
    private static final String NAME = "name";
    private static final String LOGIN = "login";
    private static final String SKIP = "skip";

    public static AppApplication singleTon = null;
    private static SharedPreferences prefs;
    private static Context context;

    /**
     * constructors
     */
    public static synchronized AppApplication getInstance(Context activityContext) {
        context = activityContext;
        if (singleTon == null) {
            singleTon = new AppApplication();
        }
        return singleTon;
    }

    public static synchronized AppApplication getInstance() {
        if (singleTon == null) {
            singleTon = new AppApplication();
        }
        return singleTon;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleTon = this;
    }

    /**
     * private method to initialize preferences
     */
    private SharedPreferences getPrefs() {
        if (prefs == null) {
            prefs = context.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE);
        }
        return prefs;
    }

    /**
     * methods to get and save preferences values
     */
    public void saveApiToken(String apiToken) {
        SharedPreferences.Editor prefEditor = getPrefs().edit();
        prefEditor.putString(API_TOKEN, apiToken);
        prefEditor.apply();
    }

    public String getApiToken() {
        return getPrefs().getString(API_TOKEN, "");
    }

    public String getName() {
        return getPrefs().getString(NAME, "");
    }

    public void saveFcmToken(String fcmToken) {
        SharedPreferences.Editor prefEditor = getPrefs().edit();
        prefEditor.putString(FCM_TOKEN, fcmToken);
        prefEditor.apply();
    }

    public String getFcmToken() {
        return getPrefs().getString(FCM_TOKEN, "");
    }

    public void setLogIn(boolean login) {
        SharedPreferences.Editor prefEditor = getPrefs().edit();
        prefEditor.putBoolean(LOGIN,login);
        prefEditor.apply();
    }

    public boolean isLogIn(){
        return getPrefs().getBoolean(LOGIN,false);
    }

    public void setSkip(boolean skip) {
        SharedPreferences.Editor prefEditor = getPrefs().edit();
        prefEditor.putBoolean(SKIP,skip);
        prefEditor.apply();
    }

    public boolean isSkipped(){
        return getPrefs().getBoolean(SKIP,false);
    }

}
