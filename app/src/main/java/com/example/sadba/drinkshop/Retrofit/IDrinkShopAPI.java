package com.example.sadba.drinkshop.Retrofit;

import com.example.sadba.drinkshop.Model.Banner;
import com.example.sadba.drinkshop.Model.CheckUserResponse;
import com.example.sadba.drinkshop.Model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IDrinkShopAPI {

    @FormUrlEncoded
    @POST("checkuser.php")
    Call<CheckUserResponse> checkUserExists(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("register.php")
    Call<User> registerNewUser(@Field("phone") String phone,
                               @Field("name") String name,
                               @Field("adress") String adress,
                               @Field("birthday") String birthday);

    @FormUrlEncoded
    @POST("getUser.php")
    Call<User> getUserInformation(@Field("phone") String phone);

    @GET("getBanner.php")
    Observable<List<Banner>> getBanners();
}
