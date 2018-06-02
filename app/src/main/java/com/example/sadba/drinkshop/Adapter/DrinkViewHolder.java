package com.example.sadba.drinkshop.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sadba.drinkshop.Interface.IItemClickListener;
import com.example.sadba.drinkshop.R;

import org.w3c.dom.Text;

public class DrinkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView img_product;
    TextView txt_drink_name, txt_price;

    IItemClickListener iItemClickListener;

    public void setiItemClickListener(IItemClickListener iItemClickListener) {
        this.iItemClickListener = iItemClickListener;
    }

    public DrinkViewHolder(View itemView) {
        super(itemView);

        img_product = itemView.findViewById(R.id.image_product);
        txt_drink_name = itemView.findViewById(R.id.txt_drink_name);
        txt_price = itemView.findViewById(R.id.txt_price);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        iItemClickListener.onClick(v);
    }
}
