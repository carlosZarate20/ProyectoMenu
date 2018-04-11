package com.example.carloszarate.proyectomenu.adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carloszarate.proyectomenu.R;

public class MenuAdapter extends ArrayAdapter<String> {
    Context myContext;
    int[] imagen;
    String[] nombre;

    public MenuAdapter(Context context, int[] imagen, String[] nombre) {
        super(context, R.layout.menu_grade,nombre);
        this.myContext = myContext;
        this.imagen = imagen;
        this.nombre = nombre;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.menu_grade,null);
        ImageView imageView = (ImageView) row.findViewById(R.id.imagenView);
        final TextView textView = (TextView) row.findViewById(R.id.textView);
        imageView.setImageResource(imagen[position]);
        textView.setText(nombre[position]);
        return row;
    }
}
