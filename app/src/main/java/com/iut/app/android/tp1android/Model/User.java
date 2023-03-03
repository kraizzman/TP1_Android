package com.iut.app.android.tp1android.Model;

import java.io.Serializable;

public class User implements Serializable {
    public String gender;
    public String name;
    public String firstName;
    public String birthDate;
    public String phone;
    public String email;
    public String zipCode;
    public String address;
    public User(String gender, String name, String firstName, String birthDate, String phone, String email, String zipCode, String address) {
        this.gender = gender;
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.zipCode = zipCode;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }
}