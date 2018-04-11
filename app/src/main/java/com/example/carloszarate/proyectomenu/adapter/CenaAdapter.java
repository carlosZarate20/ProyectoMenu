package com.example.carloszarate.proyectomenu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carloszarate.proyectomenu.R;
import com.example.carloszarate.proyectomenu.activities.DetailActivity;
import com.example.carloszarate.proyectomenu.model.Food;

import java.util.ArrayList;

public class CenaAdapter extends RecyclerView.Adapter<CenaAdapter.ViewHolder> {
    private Context mContext;
    ArrayList<Food> mList ;

    public CenaAdapter(Context mContext, ArrayList<Food> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.food_grade,null);
        CenaAdapter.ViewHolder viewHolder = new CenaAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final String title = mList.get(position).getName();
        final int image = mList.get(position).getImage();
        final String descripcion = mList.get(position).getDescripcion();
        final Food foodItem = mList.get(position);

        final ImageView imagen = holder.item_image;
        final TextView name,price;
        name = holder.item_text;
        price = holder.item_price;

        imagen.setImageResource(foodItem.getImage());
        name.setText(foodItem.getName());
        price.setText(foodItem.getPrice());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DetailActivity.class);
                intent.putExtra("NAME_KEY", title);
                intent.putExtra("IMAGE_KEY",image);
                intent.putExtra("Description",descripcion);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView item_image;
        TextView item_text, item_price;
        CardView cardView;

        public ViewHolder(View itemView){
            super(itemView);

            item_image = itemView.findViewById(R.id.imagenView2);
            item_text = itemView.findViewById(R.id.textView2);
            item_price = itemView.findViewById(R.id.priceView);
            cardView = itemView.findViewById(R.id.cardview);

        }

    }
}
