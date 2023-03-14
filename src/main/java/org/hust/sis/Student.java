package org.hust.sis;

import java.util.HashMap;
import java.util.Map;

public class Student extends User{

    private Map< Class , Float > grades;



    public Student(String name, String ID, String username, String password) {
        super(name, ID, username, password);
        this.grades = new HashMap<>();
    }
    public Map<Class, Float>  getGrades() {
        return grades;
    }

    public void updateGradesOfAClass(Class class1, Float grade) {
        grades.put(class1 , grade);
    }

}
