package com.example.android.geidea.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {

    @SerializedName("page")
    private long page;
    @SerializedName("per_page")
    private long perPage;
    @SerializedName("total")
    private long total;
    @SerializedName("total_pages")
    private long totalPages;
    @SerializedName("data")
    private List<Data> data;
    @SerializedName("ad")
    private Ad ad;

    public long getPage() { return page; }
    public void setPage(long value) { this.page = value; }

    public long getPerPage() { return perPage; }
    public void setPerPage(long value) { this.perPage = value; }

    public long getTotal() { return total; }
    public void setTotal(long value) { this.total = value; }

    public long getTotalPages() { return totalPages; }
    public void setTotalPages(long value) { this.totalPages = value; }

    public List<Data> getData() { return data; }
    public void setData(List<Data> value) { this.data = value; }

    public Ad getAd() { return ad; }
    public void setAd(Ad value) { this.ad = value; }

    @Override
    public String toString() {
        return "Users{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", total=" + total +
                ", totalPages=" + totalPages +
                ", data=" + data +
                ", ad=" + ad +
                '}';
    }
}
