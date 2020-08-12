package com.example.android.geidea.model;

import java.util.List;

public class Users {

    private long page;
    private long perPage;
    private long total;
    private long totalPages;
    private List<Data> data;
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
