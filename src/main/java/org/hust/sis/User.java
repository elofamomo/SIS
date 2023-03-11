package org.hust.sis;

import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private String ID;
    private String username;
    private String password;
    private String role;
    private List<String> enrolledClass;


    public User(String name, String ID, String username, String password) {
        this.name = name;
        this.ID = ID;
        this.username = username;
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void enroll(SisSystem sisSystem, String classCode) {

//        for (String i : sisSystem.getClass()) {

        }
//        public void showEnrollClass(SisSystem sisSystem ){
//        for (String i : enrolledClass){
//            if (sisSystem.getClass().co)
//        }
//
//        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(username, password);
//    }

