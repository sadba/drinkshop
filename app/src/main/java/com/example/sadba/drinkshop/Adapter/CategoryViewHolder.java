package com.example.sadba.drinkshop.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sadba.drinkshop.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    ImageView img_product;
    TextView txt_menu_name;
    public CategoryViewHolder(View itemView){
        super(itemView);

        img_product = itemView.findViewById(R.id.image_product);
        txt_menu_name = itemView.findViewById(R.id.txt_menu_name);
    }
}
