package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ReadAndSaveData {

    // load student info
    static Path studentPath = Paths.get("studentAccount.csv");
    static List<String> studentsName = new ArrayList<>();
    static List<String> studentsId = new ArrayList<>();
    static List<String> studentsUsername = new ArrayList<>();
    static List<String> studentsPassword = new ArrayList<>();


    // load manager info
    static Path managerPath = Paths.get("managerAccount.csv");
    static List<String> managersName = new ArrayList<>();
    static List<String> managersId = new ArrayList<>();
    static List<String> managersUsername = new ArrayList<>();
    static List<String> managersPassword = new ArrayList<>();

    // load Class info
    static Path classPath = Paths.get("classList.csv");
    static List<String> classesName = new ArrayList<>();
    static List<String> classesSubjectName = new ArrayList<>();
    static List<String> classNameGrades = new ArrayList<>();
    static List<String> studentIdGrades = new ArrayList<>();
    static List<String> studentNameGrades = new ArrayList<>();
    static List<Float> studentGrades = new ArrayList<>();


    // load Subject info

    enum AccountType {
        STUDENT, MANAGER
    }

    ReadAndSaveData() {
        loadData();
    }

    public static void loadData() {
        //load studentAccount.csv
        try (BufferedReader br = Files.newBufferedReader(studentPath, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                studentsName.add(attributes[0]);
                studentsId.add(attributes[1]);
                studentsUsername.add(attributes[2]);
                studentsPassword.add(attributes[3]);

                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
// load managerAccount.csv
        try (BufferedReader br = Files.newBufferedReader(managerPath, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                managersName.add(attributes[0]);
                managersId.add(attributes[1]);
                managersUsername.add(attributes[2]);
                managersPassword.add(attributes[3]);

                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    // load classList.csv

    // load all f-class file
    public static void loadAllFClassFile() {
        try (BufferedReader br = Files.newBufferedReader(classPath, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                classesName.add(attributes[0]);
                classesSubjectName.add(attributes[1]);

                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        // read the grade in class csv file
        for (String className : classesName) {
            Path fClassPath = Paths.get("gradeData/" + className + ".csv");
            try (BufferedReader br = Files.newBufferedReader(fClassPath, StandardCharsets.US_ASCII)) {
                String line = br.readLine();
                while (line != null) {
                    String[] attributes = line.split(",");
                    classNameGrades.add(className);
                    studentNameGrades.add(attributes[0]);
                    studentIdGrades.add(attributes[1]);
                    studentGrades.add(Float.parseFloat(attributes[2]));


                    line = br.readLine();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    // read classes of a student
    public static List<String> readClassesOfAStudent(String studentId) {
        loadAllFClassFile();
        List<String> classesOfAStudent = new ArrayList<>();
        for (int i = 0; i < studentIdGrades.size(); i++) {
            if (studentIdGrades.get(i).equals(studentId)) {
                classesOfAStudent.add(classNameGrades.get(i));
            }
        }
        return classesOfAStudent;
    }

    public static Map<String, Float> readGradesOfAStudent(List<String> studentClasses) {
        Map<String, Float> gradesOfAStudent = new HashMap<>();
        for (int i = 0; i < studentClasses.size(); i++) {
            for (int j = 0; j < classNameGrades.size(); j++) {
                if (studentClasses.get(i).equals(classNameGrades.get(j))) {
                    gradesOfAStudent.put(classNameGrades.get(j), studentGrades.get(j));
                }
            }
        }
        return gradesOfAStudent;
    }

    public static List<String> readSubjectsOfAStudent(List<String> studentClasses) {
        List<String> subjectsOfAStudent = new ArrayList<>();
        for (int i = 0; i < classesName.size(); i++) {
            if (studentClasses.contains(classesName.get(i))) {
                subjectsOfAStudent.add(classesSubjectName.get(i));
            }
        }
        return subjectsOfAStudent;
    }


    // save data
    public static void saveClassData(Path path, List<String> studentName, List<String> studentId, List<Float> studentGrade) {

        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (int i = 0; i < studentName.size(); i++) {
                bw.write(studentName.get(i) + "," + studentId.get(i) + "," + studentGrade.get(i));
                bw.newLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public static List<String> readStudentsIdOfAClass(String className) {
        List<String> studentsIdOfAClass = new ArrayList<>();
        for (int i = 0; i < classNameGrades.size(); i++) {
            if (classNameGrades.get(i).equals(className)) {
                studentsIdOfAClass.add(studentIdGrades.get(i));
            }
        }
        return studentsIdOfAClass;
    }

    public static List<Float> readStudentsGradeOfAClass(String className) {
        List<Float> studentsGradeOfAClass = new ArrayList<>();
        for (int i = 0; i < classNameGrades.size(); i++) {
            if (classNameGrades.get(i).equals(className)) {
                studentsGradeOfAClass.add(studentGrades.get(i));
            }
        }
        return studentsGradeOfAClass;
    }

    public static List<String> getStudentsNameList() {
        return studentsName;
    }

    public static List<String> getStudentsIdList() {
        return studentsId;
    }

    public static List<String> getStudentsUsernameList() {
        return studentsUsername;
    }

    public static List<String> getStudentsPasswordList() {
        return studentsPassword;
    }

    public static List<String> getManagersNameList() {
        return managersName;
    }

    public static List<String> getManagersIdList() {
        return managersId;
    }

    public static List<String> getManagersUsernameList() {
        return managersUsername;
    }

    public static List<String> getManagersPasswordList() {
        return managersPassword;
    }

    public static List<String> getClassesNameList() {
        return classesName;
    }

    public static List<String> getClassesSubjectNameList() {
        return classesSubjectName;
    }

    public static List<String> readAccount(String username, String password) {
        if (studentsUsername.contains(username) && password.equals(studentsPassword.get(studentsUsername.indexOf(username)))) {
            return Arrays.asList("Student", studentsId.get(studentsUsername.indexOf(username)));
        } else if (managersUsername.contains(username) && password.equals(managersPassword.get(managersUsername.indexOf(username)))) {
            return Arrays.asList("Manager", managersId.get(managersUsername.indexOf(username)));
        } else {
            return Arrays.asList("Invalid username or password", "");
        }
    }

    public static List<String> getStudentInfo(String id) {
        return Arrays.asList(studentsName.get(studentsId.indexOf(id)), studentsUsername.get(studentsId.indexOf(id)), studentsPassword.get(studentsId.indexOf(id)));
    }

    public static Map<String, Float> readGrade() {
        return null;
    }
}
