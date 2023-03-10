package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Class {
    private String subject;
    private static String name;
    private static List<String> studentIdList = new ArrayList<>();
    private static List<String> studentNameList = new ArrayList<>();
    private static List<Float>  studentGradesList = new ArrayList<>();

    private static ReadAndSaveData readClassinfo = new ReadAndSaveData();

    private static Path classPath;



    public Class(String name) {

        this.name = name;
        this.studentIdList = readClassinfo.readStudentsIdOfAClass(name);
        this.studentNameList = getStudentNameList();
        this.studentGradesList = readClassinfo.readStudentsGradeOfAClass(name);
        this.classPath = Paths.get("gradeData/"+ name + ".csv");


    }

    public static List<String> getStudentIdList() {
        return studentIdList;
    }
    public static List<String> getStudentNameList() {
        for (String i : studentIdList) {
            studentNameList.add(readClassinfo.getStudentInfo(i).get(0));
        }
        return studentNameList;
    }
    public static List<Float> getStudentGradesList() {

        return studentGradesList;
    }


    public static void addStudent(String studentId) {
        studentIdList.add(studentId);
        studentNameList.add(readClassinfo.getStudentInfo(studentId).get(0));
        studentGradesList.add((float) 0); // new student has grade 0



        // write to file
        ReadAndSaveData.saveClassData(classPath , studentNameList , studentIdList , studentGradesList);
    }
    public  void removeStudent(String studentId) {
        int index = studentIdList.indexOf(studentId);
        studentIdList.remove(studentId);
        studentNameList.remove(readClassinfo.getStudentInfo(studentId).get(0));
        studentGradesList.remove(index);

        // write to file
        ReadAndSaveData.saveClassData(classPath , studentNameList , studentIdList , studentGradesList);

    }
    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }



    public void addStudent(Student student) {



    }



}
