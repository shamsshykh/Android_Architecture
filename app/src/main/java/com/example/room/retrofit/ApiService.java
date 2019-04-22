package com.example.room.retrofit;

import com.example.room.db.entity.Student;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    @POST("/user/login")
    Call<Student> SUBMIT_REQUEST_LOGIN(@Body JsonObject REQUEST);
//
//    @POST("/label")
//    Call<Genericresponse> SUBMIT_REQUEST_ADD_LABEL(@Body JsonObject REQUEST);
//
//    @GET("/label")
//    Call<GetAllLabelResponse> SUBMIT_REQUEST_GET_LABEL();
//
//    @POST("label/balance")
//    Call<TotalBillResponse> SUBMIT_REQUEST_GET_TOTAL_BILL();
//
//    @PUT("/label")
//    Call<Genericresponse> SUBMIT_REQUEST_UPDATE_LABEL(@Body JsonObject REQUEST);
//
//    @POST("/record")
//    Call<Genericresponse> SUBMIT_REQUEST_ADD_BILL(@Body JsonObject REQUEST);
//
//    @PUT("/record")
//    Call<Genericresponse> SUBMIT_REQUEST_UPDATE_BILL(@Body JsonObject REQUEST);
//
//    @DELETE("/label/{id}")
//    Call<Genericresponse> SUBMIT_REQUEST_DLT_LABEL_BY_ID(@Path("id") String s);
//
//    @DELETE("/record/{id}")
//    Call<Genericresponse> SUBMIT_REQUEST_DLT_RECORD_BY_ID(@Path("id") String s);
//
//    @POST("/record/filter")
//    Call<Billresponse> REQUEST_FILTER_RECORD(@Body JsonObject REQUEST);
//
//    @Multipart
//    @POST("user/delegate")
//    Call<GlanceResponse> SUBMIT_REQUEST_BECOME_DELEGATE(@Part MultipartBody.Part file, @Part(Constants.FULL_NAME) RequestBody fname, @Part(Constants.EMAIL) RequestBody email, @Part(Constants.PHONE_NUMBER) RequestBody phonenumber, @Part(Constants.ADDRESS) RequestBody address);
//
//    @GET("user/speakers")
//    Call<SpeakersResponse> REQUEST_GET_SPEAKERS();
//
//
//    @GET("user/sponsors")
//    Call<SponserResponse> REQUEST_GET_SPONSERS();
//
//    @GET("user/events/{day}")
//    Call<EventResponse> REQUEST_GET_EVENTS(@Path("day") String day);

}
