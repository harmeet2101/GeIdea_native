package com.example.android.geidea.model;

import com.google.gson.annotations.SerializedName;

public class Ad {

    @SerializedName("company")
    private String company;
    @SerializedName("url")
    private String url;
    @SerializedName("text")
    private String text;

    public String getCompany() { return company; }
    public void setCompany(String value) { this.company = value; }

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }

    public String getText() { return text; }
    public void setText(String value) { this.text = value; }

    @Override
    public String toString() {
        return "Ad{" +
                "company='" + company + '\'' +
                ", url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
