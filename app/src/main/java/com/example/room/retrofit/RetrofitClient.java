package com.example.room.retrofit;

import com.example.room.utils.Constants;
import com.facebook.stetho.okhttp3.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static ApiService apiInterface;
    private static RetrofitClient instance;
    /**
     * Create SingleTon class with activityContext
     */
    public synchronized static RetrofitClient getInstance() {
        if(instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    private RetrofitClient() {
            OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder();
            httpClient.connectTimeout(5, TimeUnit.SECONDS);
            httpClient.readTimeout(15, TimeUnit.SECONDS);
            httpClient.writeTimeout(15, TimeUnit.SECONDS);

            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient.addInterceptor(interceptor);
                // log using OkHttp
            }

        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();

            apiInterface = retrofit.create(ApiService.class);
    }

    public ApiService getAuthAPI() {
        return apiInterface;
    }



}
