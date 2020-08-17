package com.example.android.geidea.room;

import androidx.room.TypeConverter;

import com.example.android.geidea.model.Data;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DataConvertor {

    @TypeConverter
    public String fromDataList(List<Data> dataList) {
        if (dataList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Data>>() {}.getType();
        String json = gson.toJson(dataList, type);
        return json;
    }

    @TypeConverter
    public List<Data> toDataList(String str) {
        if (str == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Data>>() {}.getType();
        List<Data> dataList = gson.fromJson(str, type);
        return dataList ;
    }
}
