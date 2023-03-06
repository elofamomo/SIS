package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        // load classList.csv
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
}
