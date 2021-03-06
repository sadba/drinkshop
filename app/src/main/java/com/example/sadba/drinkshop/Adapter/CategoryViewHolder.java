package com.example.sadba.drinkshop.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sadba.drinkshop.Interface.IItemClickListener;
import com.example.sadba.drinkshop.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView img_product;
    TextView txt_menu_name;

    IItemClickListener iItemClickListener;

    public void setiItemClickListener(IItemClickListener iItemClickListener) {
        this.iItemClickListener = iItemClickListener;
    }

    public CategoryViewHolder(View itemView){
        super(itemView);

        img_product = itemView.findViewById(R.id.image_product);
        txt_menu_name = itemView.findViewById(R.id.txt_menu_name);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        iItemClickListener.onClick(v);
    }
}
