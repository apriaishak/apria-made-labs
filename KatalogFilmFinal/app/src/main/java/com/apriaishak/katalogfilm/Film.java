package com.apriaishak.katalogfilm;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {

    private int poster;

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getRilis() {
        return rilis;
    }

    public void setRilis(String rilis) { this.rilis = rilis; }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getPemain() {
        return pemain;
    }

    public void setPemain(String pemain) {
        this.pemain = pemain;
    }

    public String getKreator() {
        return kreator;
    }

    public void setKreator(String kreator) {
        this.kreator = kreator;
    }

    private String rilis;
    private String judul;
    private String sinopsis;
    private String pemain;
    private String kreator;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.rilis);
        dest.writeString(this.judul);
        dest.writeString(this.sinopsis);
        dest.writeString(this.pemain);
        dest.writeString(this.kreator);
    }

    public Film() {
    }

    protected Film(Parcel in) {
        this.poster = in.readInt();
        this.rilis = in.readString();
        this.judul = in.readString();
        this.sinopsis = in.readString();
        this.pemain = in.readString();
        this.kreator = in.readString();
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
