package org.hust.sis.dao;

import org.hust.sis.*;
import org.hust.sis.Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.nio.file.StandardOpenOption.APPEND;

public class CsvFileSisDataAccess implements SisDataAccess {

    final private Path studentPath = Paths.get("src/main/resources/user/studentAccount.csv");
    final private Path managerPath = Paths.get("src/main/resources/user/managerAccount.csv");

    @Override
    public void addUser(User user) {
        // mo file
        // luu them vao file
        // dong file
        if (user instanceof Student) {
            // write student information into studentAccount.csv
            try (BufferedWriter bw = Files.newBufferedWriter(studentPath, StandardCharsets.UTF_8, APPEND)) {
                bw.write(user.getName() + "," + user.getID() + "," + user.getUsername() + "," + user.getPassword());
                bw.newLine();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        if(user instanceof Manager) {
            try (BufferedWriter bw = Files.newBufferedWriter(managerPath, StandardCharsets.UTF_8, APPEND)) {
                bw.write(user.getName() + "," + user.getID() + "," + user.getUsername() + "," + user.getPassword());
                bw.newLine();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    @Override
    public void deleteStudent(Student student) {

    }

    @Override
    public Class findClassByCode(String classCode) {
        return null;
    }

    @Override
    public void addClass(Class clazz) {

    }

    @Override
    public void deleteClass(Class class1) {

    }

    @Override
    public void addSubject(Subject subject) {

    }

    @Override
    public void showAllSubjects() {

    }

    @Override
    public Subject findSubjectByCode(String code) {
        return null;
    }

    @Override
    public void enroll(User user, Class class1) {

    }

    @Override
    public void disenroll(User user, Class class1) {

    }

    @Override
    public void addPreviousSemesterClass(Class class1) {

    }

    @Override
    public Map<String, Float> getGradesOfAStudent(Student student) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(studentPath, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null && !line.isBlank()) {
                String[] attributes = line.split(",");
                users.add(new Student (attributes[0], attributes[1] , attributes[2], attributes[3]));
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try (BufferedReader br = Files.newBufferedReader(managerPath, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                users.add(new Manager (attributes[0], attributes[1] , attributes[2], attributes[3]));
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Class> getClasses() {
        return null;
    }

    @Override
    public List<Subject> getSubjects() {
        return null;
    }

    @Override
    public void deleteSubject(Subject subject) {

    }

    @Override
    public List<Student> findStudentsByClass(Class class1) {
        return null;
    }

    @Override
    public void addGrades(Student student, Class class1, Float grade) {

    }

    @Override
    public Subject convertSubjectNameToSubject(String subjectName) {
        return null;
    }



    @Override
    public List<Student> findStudentByClass(Class class1) {
        return null;
    }

    @Override
    public List<Class> getClassesByUser(User user) {
        return null;
    }

    @Override
    public Subject convertSubjectCodetoSubject(String subjectCode) {
        return null;
    }

    @Override
    public void updateStudentGrades(Student student, Class class1, Float grade) {

    }

    @Override
    public Class convertClassCodetoClass(String classCode) {
        return null;
    }

    @Override
    public String getUserName(User user) {
        try (BufferedReader br = Files.newBufferedReader(studentPath, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                if ( attributes[0].equals(user.getName())){
                    return user.getName();
                }
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    @Override
    public String getUserID(User user) {
        try (BufferedReader br = Files.newBufferedReader(studentPath, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                if ( attributes[1].equals(user.getID())){
                    return user.getID();
                }
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getUnenrolledClassesByUser(User user) {
        return null;
    }

    @Override
    public List<String> getClassesCodeByUser(User user) {
        return null;
    }
}


