package com.example.livedata.utils;

import com.example.livedata.models.BaseResponse;
import com.example.livedata.models.Office;
import com.example.livedata.models.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @GET("datamakanan.php")
    Call<List<Office>> getOffice();

    @FormUrlEncoded
    @POST("login.php")
    Call <BaseResponse<User>> authLogin(@Field("username") String username,
                                        @Field("password") String password);

    @FormUrlEncoded
    @POST("DB_Connect.php")
    Call <BaseResponse> register(@Field("username") String username,
                                       @Field("nama") String name,
                                       @Field("password") String password);
}
