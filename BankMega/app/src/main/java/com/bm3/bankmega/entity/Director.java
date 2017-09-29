package com.bm3.bankmega.entity;

/**
 * Created by myremote on 9/26/2017.
 */

public class Director extends Manager {


    public void bonus() {
        System.out.println("bonus : 200 jt");
    }

    public  void bonusManager(){
        super.bonus();
        Manager manager = new Manager();
        manager.bonus();
    }
}
