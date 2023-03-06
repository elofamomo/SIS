package org.example;

public class gradeToStudent {

    private String studentID;
    private String subjectID;
    private float grade;

    public gradeToStudent(String studentID, String subjectID, float grade) {
        this.studentID = studentID;
        this.subjectID = subjectID;
        this.grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public float getGrade() {
        return grade;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String toString() {
        return "Student ID: " + studentID + " Subject ID: " + subjectID + " Grade: " + grade;
    }
}
