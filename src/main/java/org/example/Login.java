package org.example;

import java.util.List;
import java.util.Scanner;

public class Login {

    private static Scanner scanner = new Scanner(System.in);


    Login() {
        welcomeWord();
    }

    public static void welcomeWord() {
        System.out.println("Welcome to Student Information System");
        System.out.println("Please choose option below:");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        String loginOption = scanner.nextLine();
        if (loginOption.equals("1")) {
            logIN();
        } else if (loginOption.equals("2")) {
            exit();
        } else {
            System.out.println("Invalid option");
            welcomeWord();
        }
    }

    public static void logIN() {
        System.out.print("\nEnter your username: ");
        String username = scanner.next();

        System.out.print("Enter your password: ");
        String password = scanner.next();

        //load account from file
        ReadAndSaveData accountReader = new ReadAndSaveData();
        List<String> accountType = accountReader.readAccount(username, password);


        if (accountType.get(0).equals("Manager")) {

            initManagerSession(accountType.get(1));
        } else if (accountType.get(0).equals("Student")) {
            initStudentSession(accountType.get(1));
        } else {
            System.out.println(accountType);
            welcomeWord();
        }

    }

    public static void initStudentSession(String studentId) {
        Student student = new Student(studentId);
        student.studentGreetingSession();


    }

    public static void initManagerSession(String managerId) {
        Manager manager = new Manager(managerId);
        manager.managerGreetingSession();
    }


    public static void logOUT() {

    }

    public static void exit() {
        System.exit(0);
    }

}
