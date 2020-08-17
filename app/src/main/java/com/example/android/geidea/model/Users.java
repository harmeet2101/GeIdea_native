package com.example.android.geidea.model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.android.geidea.room.DataConvertor;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "users")
public class Users {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @SerializedName("page")
    @ColumnInfo
    private long page;
    @SerializedName("per_page")
    @ColumnInfo
    private long perPage;
    @SerializedName("total")
    @ColumnInfo
    private long total;
    @SerializedName("total_pages")
    @ColumnInfo
    private long totalPages;

    @TypeConverters(DataConvertor.class)
    private List<Data> data;
    @ColumnInfo
    @Ignore
    private Ad ad;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
                "id=" + id +
                ", page=" + page +
                ", perPage=" + perPage +
                ", total=" + total +
                ", totalPages=" + totalPages +
                ", data=" + data +
                ", ad=" + ad +
                '}';
    }
}
