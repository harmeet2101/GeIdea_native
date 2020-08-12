package com.example.android.geidea.model;

public class UserDetails {

    private Data data;
    private Ad ad;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "data=" + data +
                ", ad=" + ad +
                '}';
    }
}
