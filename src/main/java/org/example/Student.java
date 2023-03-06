package org.example;

import java.util.ArrayList;

class Student {
    private String id;
    private String name;
    private String username;
    private String password;
    private String className;
    private ArrayList<Subject> subjects = new ArrayList<>();

    public Student(String id) {
        this.id = id;


    }

    public String getId() {
        return id;
    }




    public String getName() {
        return name;
    }



    public String getUsername() {
        return username;
    }



    public String getPassword() {
        return password;
    }

    public String getClassName() {
        return className;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public void unsetSubjects() {
        this.subjects = null;
    }


}
