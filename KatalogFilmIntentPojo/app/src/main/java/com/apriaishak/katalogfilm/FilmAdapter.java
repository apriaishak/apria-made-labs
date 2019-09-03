package com.apriaishak.katalogfilm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Film> films;

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    public FilmAdapter(Context context) {
        this.context = context;
        films = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_film, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Film film = (Film) getItem(i);
        viewHolder.bind(film);
        return view;
    }

    private class ViewHolder {
        private ImageView imgPoster;
        private TextView txtJudul;
        private TextView txtRilis;
        private TextView txtSinopsis;


        ViewHolder(View view) {

            imgPoster = view.findViewById(R.id.img_poster);
            txtJudul = view.findViewById(R.id.txt_judul);
            txtRilis = view.findViewById(R.id.txt_rilis);
            txtSinopsis = view.findViewById(R.id.txt_sinopsis);
        }

        void bind(Film films) {
            imgPoster.setImageResource(films.getPoster());
            txtJudul.setText(films.getJudul());
            txtRilis.setText(films.getRilis());
            txtSinopsis.setText(films.getSinopsis());

        }
    }
}
