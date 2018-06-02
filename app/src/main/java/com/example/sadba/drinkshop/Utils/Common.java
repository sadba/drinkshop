package com.example.sadba.drinkshop.Utils;

import com.example.sadba.drinkshop.Model.Category;
import com.example.sadba.drinkshop.Model.User;
import com.example.sadba.drinkshop.Retrofit.IDrinkShopAPI;
import com.example.sadba.drinkshop.Retrofit.RetrofitCLient;

public class Common {

    private static final String BASE_URL = "http://192.168.1.15/drinkshop/";

    public static  User currentUser = null;
    public static Category currentCategory = null;

    public static IDrinkShopAPI getAPI()
    {
        return RetrofitCLient.getClient(BASE_URL).create(IDrinkShopAPI.class);
    }
}
