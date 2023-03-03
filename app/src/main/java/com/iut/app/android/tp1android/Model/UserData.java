package com.iut.app.android.tp1android.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class UserData implements Serializable {
    private final String gender;
    private final String name;
    private final String firstName;
    private final String birthDate;
    private final String phone;
    private final String email;
    private final String zipCode;
    private final String address;

    public UserData(String gender, String name, String firstName, String birthDate, String phone, String email, String zipCode, String address)
    {
        this.gender = gender;
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.zipCode = zipCode;
        this.address = address;
    }

    public String getGender() {
        return gender;
    }
    public String getName()
    {
        return name;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getBirthDate()
    {
        return birthDate;
    }
    public String getPhone()
    {
        return phone;
    }
    public String getEmail()
    {
        return email;
    }
    public String getZipCode()
    {
        return zipCode;
    }
    public String getAddress()
    {
        return address;
    }
}
