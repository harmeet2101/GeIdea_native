package com.example.android.geidea.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "data")
public class Data {

    @SerializedName("id")
    @PrimaryKey
    private long id;
    @SerializedName("email")
    @ColumnInfo(name = "email")
    private String email;
    @SerializedName("first_name")
    @ColumnInfo(name = "firstName")
    private String firstName;
    @SerializedName("last_name")
    @ColumnInfo(name = "lastName")
    private String lastName;
    @SerializedName("avatar")
    @ColumnInfo(name = "avatar")
    private String avatar;
    @ColumnInfo(name = "userId")
    @ForeignKey(entity = Users.class,
            parentColumns = "id",
            childColumns = "userId",
            onDelete = ForeignKey.CASCADE)
    public  int userId;

    public Data() {
    }

    public Data(long id, String email, String firstName, String lastName, String avatar) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    public long getId() { return id; }
    public void setId(long value) { this.id = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String value) { this.firstName = value; }

    public String getLastName() { return lastName; }
    public void setLastName(String value) { this.lastName = value; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String value) { this.avatar = value; }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
