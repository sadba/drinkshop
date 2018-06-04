package com.example.sadba.drinkshop.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.sadba.drinkshop.Database.ModelDB.Cart;
import com.example.sadba.drinkshop.Interface.IItemClickListener;
import com.example.sadba.drinkshop.Model.Drink;
import com.example.sadba.drinkshop.R;
import com.example.sadba.drinkshop.Utils.Common;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkViewHolder> {

    Context context;
    List<Drink> drinkList;

    public DrinkAdapter(Context context, List<Drink> drinkList) {
        this.context = context;
        this.drinkList = drinkList;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.drink_item_layout, null);
        return new DrinkViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, final int position) {

        holder.txt_price.setText(new StringBuilder("$").append(drinkList.get(position).getPrice()).toString());
        holder.txt_drink_name.setText(drinkList.get(position).getName());

        holder.btn_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddToCartDialog(position);
            }
        });

        Picasso.with(context)
                .load(drinkList.get(position).getLink())
                .into(holder.img_product);


        holder.setiItemClickListener(new IItemClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showAddToCartDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.add_to_cart_layout, null);

        //View
        ImageView img_product_dialog = itemView.findViewById(R.id.img_card_product);
        final ElegantNumberButton txt_count = (ElegantNumberButton) itemView.findViewById(R.id.txt_count);
        TextView txt_product_dialog = itemView.findViewById(R.id.txt_cart__product_name);

        EditText edt_comment = itemView.findViewById(R.id.edt_comment);

        RadioButton rdi_sizeM = itemView.findViewById(R.id.rdi_sizeM);
        RadioButton rdi_sizeL = itemView.findViewById(R.id.rdi_sizeL);

        rdi_sizeM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Common.sizeOfCup = 0;
                }
            }
        });

        rdi_sizeL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Common.sizeOfCup = 1;
                }
            }
        });

        RadioButton rdi_sugar_100 = itemView.findViewById(R.id.rdi_sugar_100);
        RadioButton rdi_sugar_70 = itemView.findViewById(R.id.rdi_sugar_70);
        RadioButton rdi_sugar_50 = itemView.findViewById(R.id.rdi_sugar_50);
        RadioButton rdi_sugar_30 = itemView.findViewById(R.id.rdi_sugar_30);
        RadioButton rdi_sugar_free = itemView.findViewById(R.id.rdi_sugar_free);

        rdi_sugar_30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Common.sugar = 30;
                }
            }
        });

        rdi_sugar_50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Common.sugar = 50;
                }
            }
        });

        rdi_sugar_70.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Common.sugar = 70;
                }
            }
        });

        rdi_sugar_100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Common.sugar = 100;
                }
            }
        });

        rdi_sugar_free.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Common.sugar = 0;
                }
            }
        });

        RadioButton rdi_ice_100 = itemView.findViewById(R.id.rdi_ice_100);
        RadioButton rdi_ice_70 = itemView.findViewById(R.id.rdi_ice_70);
        RadioButton rdi_ice_50 = itemView.findViewById(R.id.rdi_ice_50);
        RadioButton rdi_ice_30 = itemView.findViewById(R.id.rdi_ice_30);
        RadioButton rdi_ice_free = itemView.findViewById(R.id.rdi_ice_free);

        rdi_ice_30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Common.ice = 30;
                }
            }
        });

        rdi_ice_50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Common.ice = 50;
                }
            }
        });

        rdi_ice_70.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Common.ice = 70;
                }
            }
        });

        rdi_ice_100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Common.ice = 100;
                }
            }
        });

        rdi_ice_free.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Common.ice = 0;
                }
            }
        });

        RecyclerView recycler_topping = itemView.findViewById(R.id.recycler_topping);
        recycler_topping.setLayoutManager(new LinearLayoutManager(context));
        recycler_topping.setHasFixedSize(true);

        MultiChoiceAdapter adapter = new MultiChoiceAdapter(context, Common.toppingList);
        recycler_topping.setAdapter(adapter);

        //Set Data
        Picasso.with(context)
                .load(drinkList.get(position).getLink())
                .into(img_product_dialog);
        txt_product_dialog.setText(drinkList.get(position).getName());

        builder.setView(itemView);
        builder.setNegativeButton("ADD TO CART", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (Common.sizeOfCup == -1)
                {
                    Toast.makeText(context, "Please choose size of cup", Toast.LENGTH_SHORT).show();
                }
                if (Common.sugar == -1)
                {
                    Toast.makeText(context, "Please choose sugar", Toast.LENGTH_SHORT).show();
                }
                if (Common.ice == -1)
                {
                    Toast.makeText(context, "Please choose ice", Toast.LENGTH_SHORT).show();
                }

                showConfirmDialog(position, txt_count.getNumber());
                dialog.dismiss();
            }
        });

        builder.show();
    }

    private void showConfirmDialog(int position, final String number) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.confirm_add_to_cart_layout, null);


        //View
        ImageView img_product_dialog = itemView.findViewById(R.id.img_product);
        final TextView txt_product_dialog = itemView.findViewById(R.id.txt_cart__product_name);
        TextView txt_product_price = itemView.findViewById(R.id.txt_cart__product_price);
        TextView txt_sugar = itemView.findViewById(R.id.txt_sugar);
        TextView txt_ice = itemView.findViewById(R.id.txt_ice);
        final TextView txt_topping_extra = itemView.findViewById(R.id.txt_topping_extra);

        //Set Data
        Picasso.with(context).load(drinkList.get(position).getLink()).into(img_product_dialog);
        txt_product_dialog.setText(new StringBuilder(drinkList.get(position).getName()).append(" %")
        .append(number)
        .append(Common.sizeOfCup == 0 ? " Size M" : " Size L").toString());

        txt_ice.setText(new StringBuilder("Ice: ").append(Common.ice).append("%").toString());
        txt_sugar.setText(new StringBuilder("Sugar: ").append(Common.sugar).append("%").toString());

        double price = (Double.parseDouble(drinkList.get(position).getPrice()) * Double.parseDouble(number)) + Common.toppingPrice;

        if (Common.sizeOfCup == 1)
            price+=3.0;

        txt_product_price.setText(new StringBuilder("$").append(price));

        StringBuilder topping_final_comment = new StringBuilder("");
        for (String line:Common.toppingAdded)
            topping_final_comment.append(line).append("\n");

        txt_topping_extra.setText(topping_final_comment);

        final double finalPrice = price;
        builder.setNegativeButton("CONFIRM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                dialog.dismiss();

                try {
                    //Add to SQLITE
                    //Create new cart item
                    Cart cartItem = new Cart();
                    cartItem.name = txt_product_dialog.getText().toString();
                    cartItem.amount = Integer.parseInt(number);
                    cartItem.ice = Common.ice;
                    cartItem.sugar = Common.sugar;
                    cartItem.price = finalPrice;
                    cartItem.toppingExtras = txt_topping_extra.getText().toString();

                    //Add to DB
                    Common.cartRepository.insertToCart(cartItem);

                    Log.d("SADBA_DEBUG", new Gson().toJson(cartItem));

                    Toast.makeText(context, "Save item to cart success", Toast.LENGTH_SHORT).show();
                }
                catch (Exception ex)
                {
                    Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setView(itemView);
        builder.show();
    }


    @Override
    public int getItemCount() {
        return drinkList.size();
    }
}
