package com.example.carloszarate.proyectomenu.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carloszarate.proyectomenu.R;

public class DetailActivity extends AppCompatActivity {

    TextView title,details;
    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = (TextView) findViewById(R.id.textName);
        imagen = (ImageView) findViewById(R.id.imgFoodDetails);
        details = (TextView) findViewById(R.id.textDetails);

        Intent intent = this.getIntent();
        String name = intent.getExtras().getString("NAME_KEY");
        int image = intent.getExtras().getInt("IMAGE_KEY");
        String descripcion = intent.getExtras().getString("Description");


        title.setText(name);
        imagen.setImageResource(image);
        details.setText(descripcion);
    }
}
