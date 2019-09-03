package com.apriaishak.katalogfilm;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class FilmDetail extends AppCompatActivity {



        public static final String EXTRA_FILM = "extra_film";

        private Context context = FilmDetail.this;



        ImageView imgDetailPoster;
        TextView tvDetailJudul;
        TextView tvDetailRilis;
        TextView tvDetailSinopsis;



        @Override

        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.detail_film);



            imgDetailPoster = findViewById(R.id.img_poster);
            tvDetailJudul = findViewById(R.id.txt_judul);
            tvDetailRilis = findViewById(R.id.txt_rilis);
            tvDetailSinopsis = findViewById(R.id.txt_sinopsis);



            Film film = getIntent().getParcelableExtra(EXTRA_FILM);

            Integer poster = film.getPoster();
            String judul = "" + film.getJudul();
            String rilis = "" + film.getRilis();
            String sinopsis = "" + film.getSinopsis();




            Glide.with(context).load(poster).into(imgDetailPoster);
            tvDetailJudul.setText(judul);
            tvDetailRilis.setText(rilis);
            tvDetailSinopsis.setText(sinopsis);





        }

    }

