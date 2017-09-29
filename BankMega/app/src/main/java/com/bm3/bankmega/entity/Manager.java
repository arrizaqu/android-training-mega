package com.bm3.bankmega.entity;

import com.bm3.bankmega.entity.Employee;

/**
 * Created by myremote on 9/26/2017.
 */

public class Manager extends Employee {

    @Override
    public void bonus(){
        System.out.print("bonus : 150 jt");
    }
}
