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

    ImageView imgObject;
    TextView tvObject;
    TextView tvObjectDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        imgObject = findViewById(R.id.img_object_received);
        tvObject = findViewById(R.id.tv_object_received);
        tvObjectDesc = findViewById(R.id.tv_object_received_description);

        Hero hero = getIntent().getParcelableExtra(EXTRA_HERO);
        String text = "" + hero.getName();
        String desc = "" + hero.getDescription();
        Integer photo = hero.getPhoto();

        tvObject.setText(text);
        tvObjectDesc.setText(desc);
        Glide.with(context).load(photo).into(imgObject);
    }
}
