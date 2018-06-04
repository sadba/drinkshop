package com.example.sadba.drinkshop.Utils;

import com.example.sadba.drinkshop.Database.DataSource.CartRepository;
import com.example.sadba.drinkshop.Database.Local.CartDatabase;
import com.example.sadba.drinkshop.Model.Category;
import com.example.sadba.drinkshop.Model.Drink;
import com.example.sadba.drinkshop.Model.User;
import com.example.sadba.drinkshop.Retrofit.IDrinkShopAPI;
import com.example.sadba.drinkshop.Retrofit.RetrofitCLient;

import java.util.ArrayList;
import java.util.List;

public class Common {

    private static final String BASE_URL = "http://192.168.1.15/drinkshop/";

    public static final String TOPPING_MENU_ID = "7";

    public static  User currentUser = null;
    public static Category currentCategory = null;

    public static List<Drink> toppingList = new ArrayList<>();

    public static double toppingPrice = 0.0;
    public static List<String> toppingAdded = new ArrayList<>();

    //Hold Field
    public static int sizeOfCup = -1; //-1 : no choice (error) , 0 : M , 1 : L
    public static int sugar = -1; //-1 : no choice (error)
    public static int ice = -1;

    //Database
    public static CartDatabase cartDatabase;
    public static CartRepository cartRepository;

    public static IDrinkShopAPI getAPI()
    {
        return RetrofitCLient.getClient(BASE_URL).create(IDrinkShopAPI.class);
    }
}
