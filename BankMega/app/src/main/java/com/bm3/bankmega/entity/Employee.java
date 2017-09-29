package com.bm3.bankmega.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by myremote on 9/26/2017.
 */
//pOJO // encapsulation // bean
public class Employee{

    public Employee(){}

    private String name;
    private String address;
    private String email;

    public void bonus(){
        System.out.println("bonus : 1jt");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}










