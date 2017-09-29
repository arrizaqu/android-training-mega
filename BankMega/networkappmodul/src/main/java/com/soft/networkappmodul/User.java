package com.soft.networkappmodul;

/**
 * Created by myremote on 9/29/2017.
 */

public class User {

    private String id;
    private String name;
    private String password;
    private String isAdmin;
    private String isDeleteUser;

    public User(String id, String name, String password, String isAdmin, String isDeleteUser) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isDeleteUser = isDeleteUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getIsDeleteUser() {
        return isDeleteUser;
    }

    public void setIsDeleteUser(String isDeleteUser) {
        this.isDeleteUser = isDeleteUser;
    }
}
