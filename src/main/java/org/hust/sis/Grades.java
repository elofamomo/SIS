package org.hust.sis;

public class Grades {
    private Class class1;
    private Student student;
    private Float gradePoint;

    public Grades (Class class1 , Student student , Float gradePoint){
        this.gradePoint = gradePoint ;
        this.class1 = class1 ;
        this.student = student;
    }

    public Float getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(Float gradePoint) {
        this.gradePoint = gradePoint;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Class getClass1() {
        return class1;
    }

    public void setClass1(Class class1) {
        this.class1 = class1;
    }
}
