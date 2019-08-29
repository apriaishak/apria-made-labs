package com.apriaishak.mylistview;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MoveWithObjectActivity extends AppCompatActivity {
    public static final String EXTRA_HERO = "extra_hero";
    private Context context = MoveWithObjectActivity.this;

    TextView tvObject;
    ImageView imgObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvObject = findViewById(R.id.tv_object_received);
        imgObject = findViewById(R.id.img_object_received);

        Hero hero = getIntent().getParcelableExtra(EXTRA_HERO);
        String text = "" + hero.getName() + ",\n\n" + hero.getDescription();
        Integer photo = hero.getPhoto();
        tvObject.setText(text);
        Glide.with(context).load(photo).into(imgObject);
    }
}
