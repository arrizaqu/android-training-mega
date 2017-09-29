package com.bm3.bankmega;

import com.bm3.bankmega.entity.Director;
import com.bm3.bankmega.entity.Employee;
import com.bm3.bankmega.entity.Manager;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void main(){
        Employee employee = new Employee();
        employee.setName("ardi");
        employee.setAddress("lampung");
        employee.setEmail("arriz@yahoo.com");

        Employee manager = new Manager(); // polymorphism
        manager.setName("Devi");
        manager.setEmail("devi@yaho.com");

        Director director = new Director();
        director.setName("uya");
        director.setEmail("uya@bankmega.com");
        director.setAddress("jakarta selatan");

        System.out.println("hello unitTest");
        System.out.println("manager : "+ manager.getName());
        manager.bonus();
        System.out.println("director : "+ director.getName());
        director.bonus();
        director.bonusManager();
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
}