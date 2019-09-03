package com.apriaishak.katalogfilm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataJudul;
    private String[] dataRilis;
    private String[] dataSinopsis;
    private TypedArray dataPoster;
    private FilmAdapter adapter;
    private ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, films.get(i).getJudul(), Toast.LENGTH_SHORT).show();



                Film film = new Film();

                film.setPoster(films.get(i).getPoster());
                film.setJudul(films.get(i).getJudul());
                film.setRilis(films.get(i).getRilis());
                film.setSinopsis(films.get(i).getSinopsis());




                Intent moveWithObjectIntent = new Intent(MainActivity.this, FilmDetail.class);

                moveWithObjectIntent.putExtra(FilmDetail.EXTRA_FILM, film);

                startActivity(moveWithObjectIntent);









            }
        });
    }


    private void prepare() {
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataRilis = getResources().getStringArray(R.array.data_rilis);
        dataSinopsis = getResources().getStringArray(R.array.data_sinopsis);

    }

    private void addItem() {
        films = new ArrayList<>();

        for (int i = 0; i < dataJudul.length; i++) {
            Film film = new Film();
            film.setPoster(dataPoster.getResourceId(i, -1));
            film.setRilis(dataRilis[i]);
            film.setJudul(dataJudul[i]);
            film.setSinopsis(dataSinopsis[i]);
            films.add(film);
        }
        adapter.setFilms(films);
    }


}
