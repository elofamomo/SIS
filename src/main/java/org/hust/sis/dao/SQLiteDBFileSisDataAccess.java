package org.hust.sis.dao;

import org.hust.sis.Class;
import org.hust.sis.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SQLiteDBFileSisDataAccess implements SisDataAccess {
    private String dbFilePath = "jdbc:sqlite:src/main/resources/db/Student.db";

    @Override
    public void addUser(User user) {
        if (user instanceof Student) {
            try (Connection connection = DriverManager.getConnection(dbFilePath)) {
                if (connection != null) {
                    System.out.println("Adding user to database........");
                    String sqlInsertNewAccountCommand = "INSERT INTO userAccount VALUES( \' " + user.getUsername() + "\' , \' " + user.getID()
                            + "\' , \'" + user.getUsername() + "\' , \'" + user.getPassword() + "\' , \' Student \');";

                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sqlInsertNewAccountCommand.trim());
                    System.out.println("Add user to database success");

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else if (user instanceof Manager) {
            try (Connection connection = DriverManager.getConnection(dbFilePath)) {
                if (connection != null) {
                    System.out.println("Adding user to database........");
                    String sqlInsertNewAccountCommand = "INSERT INTO userAccount VALUES(" + user.getUsername() + "," + user.getID()
                            + "," + user.getUsername() + "," + user.getPassword() + ",Manager;";

                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sqlInsertNewAccountCommand);
                    System.out.println("Add user to database success");

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
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
        try (Connection connection = DriverManager.getConnection(dbFilePath)) {
            if (connection != null) {
                System.out.println("Adding new class to database........");
                // adding new class table into database
                String sqlInsertNewAccountCommand = "CREATE TABLE IF NOT EXISTS " + clazz.getClassCode() + " ("
                        + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + " studentID TEXT NOT NULL,"
                        + " studentName TEXT NOT NULL,"
                        + " grade REAL NOT NULL"
                        + ");";

                Statement statement = connection.createStatement();
                statement.executeUpdate(sqlInsertNewAccountCommand.trim());
                System.out.println("Add user to database success");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteClass(Class class1) {

    }

    @Override
    public void addSubject(Subject subject) {
        try (Connection connection = DriverManager.getConnection(dbFilePath)) {
            if (connection != null) {
                System.out.println("Adding subject to database........");
                // adding new subject into subjects table
                String sqlInsertNewSubjectCommand = "INSERT INTO subjects VALUES( \' " + subject.getSubjectCode() + "\' , \' " + subject.getSubjectName() + "\' );";
                Statement statement = connection.createStatement();
                statement.executeUpdate(sqlInsertNewSubjectCommand.trim());
                System.out.println("Add subject to database success");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
        try (Connection connection = DriverManager.getConnection(dbFilePath)) {
            if (connection != null) {
                System.out.println("Connect to database success");
                String sqlSelectAllCommand = "SELECT * FROM userAccount";
                Statement statement = connection.createStatement();
                // read data from resources/classes.csv
//                then conve


                ResultSet resultSet = statement.executeQuery(sqlSelectAllCommand);
                while (resultSet.next()) {
                    if (resultSet.getString("Role").trim().equals("Student")) {
                        users.add(new Student(resultSet.getString("Name"), resultSet.getString("Id"), resultSet.getString("Username"), resultSet.getString("Password")));
                    } else if (resultSet.getString("Role").trim().equals("Manager")) {
                        users.add(new Manager(resultSet.getString("Name"), resultSet.getString("Id"), resultSet.getString("Username"), resultSet.getString("Password")));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Class> getClasses() {
        List<Class> classes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(dbFilePath)) {
            if (connection != null) {
                DatabaseMetaData m = connection.getMetaData();
                ResultSet rs = m.getTables(null, null, "%", null);
                while (rs.next()) {
                    if (getAllSubjectCode().contains(rs.getString(3).substring(0, 2))) {
                        classes.add(new Class(rs.getString(3), convertSubjectCodetoSubject(rs.getString(3).substring(0, 2))));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return classes;
    }

    List<String> getAllSubjectCode() {
        List<String> subjectCodes = new ArrayList<>();
        for (Subject subject : getSubjects()) {
            subjectCodes.add(subject.getSubjectCode());
        }
        return subjectCodes;
    }

    @Override
    public List<Subject> getSubjects() {
        List<Subject> subjects = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(dbFilePath)) {
            if (connection != null) {

                String sqlSelectAllCommand = "SELECT * FROM subjects";
                Statement statement = connection.createStatement();


                ResultSet resultSet = statement.executeQuery(sqlSelectAllCommand);
                while (resultSet.next()) {
                    subjects.add(new Subject(resultSet.getString("SubjectCode"), resultSet.getString("SubjectName")));
                    System.out.println("Querying subject" + resultSet.getString("SubjectName"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return subjects;
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
        List<Class> classesOfAUser = new ArrayList<>();
        for (Class class1 : getClasses()) {
            try (Connection connection = DriverManager.getConnection(dbFilePath)) {
                if (connection != null) {
                    System.out.println("Fetching classes you have enrolled in.....");
                    String sqlSelectAllCommand = "SELECT * FROM " + class1.getClassCode() + " WHERE Username = \' " + user.getUsername() + "\'";
                    Statement statement = connection.createStatement();

                    ResultSet resultSet = statement.executeQuery(sqlSelectAllCommand);
                    while (resultSet.next()) {
                        classesOfAUser.add(new Class(resultSet.getString("ClassCode"), convertSubjectCodetoSubject(resultSet.getString("ClassCode").substring(0, 2))));
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return classesOfAUser;
    }

    @Override
    public Subject convertSubjectCodetoSubject(String subjectCode) {
        for (Subject subject : getSubjects()) {
            if (subject.getSubjectCode().equals(subjectCode)) {
                return subject;
            }
        }
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
        return user.getName();
    }

    @Override
    public String getUserID(User user) {
        return user.getID();
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
