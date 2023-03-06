package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Class {
    private String subject;
    private String name;
    private Map<String, Float> studentsGrade = new HashMap<>();

    public Class(String name, String subject) {
        this.subject = subject;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public ArrayList<String> getStudentsList() {
        return null;
    }

    public void addStudent(Student student) {



    }

    public  void removeStudent(Student student) {

    }

}
