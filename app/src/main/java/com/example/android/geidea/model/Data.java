package com.example.android.geidea.model;

public class Data {

    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String value) { this.firstName = value; }

    public String getLastName() { return lastName; }
    public void setLastName(String value) { this.lastName = value; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String value) { this.avatar = value; }

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
