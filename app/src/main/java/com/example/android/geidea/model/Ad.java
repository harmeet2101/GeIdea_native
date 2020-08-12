package com.example.android.geidea.model;

public class Ad {

    private String company;
    private String url;
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
