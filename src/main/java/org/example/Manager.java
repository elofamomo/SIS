package org.example;

import java.util.Scanner;

public class Manager {
    private static String managerName;
    private static String managerID;
    private static String managerUsername;
    private static String managerPassword;
    static ReadAndSaveData readInfo = new ReadAndSaveData();
    Scanner scanner = new Scanner(System.in);


    Manager(String managerID) {
        this.managerID = managerID;


    }

    public void managerGreetingSession() {
        System.out.println("");
        System.out.println("");
        System.out.printf("");
        System.out.println("Hi !!!");
        System.out.println("What do you want to do?");
        System.out.println("1. Add a new student info");
        System.out.println("2. Edit a student info");
        System.out.println("3. Delete a student info");
        System.out.println("4. Add a new class");
        System.out.println("5. Edit a class");
        System.out.println("6. Delete a class");
        System.out.println("7. Add a new Subject");
        System.out.println("8. Edit a Subject");
        System.out.println("9. Delete a Subject");
        System.out.println("10. Find a student by student ID");
        System.out.println("11. Find a student by student name");
        System.out.println("12. Find a class by class name");
        System.out.println("13. Find a class by class name");
        System.out.println("14. Find a subject by subject name");
        System.out.println("15. Update a student's grade");
        doManagerSession();
    }

    public void doManagerSession() {
        System.out.println("Select your choice: ");
        int studentChoice = scanner.nextInt();

        switch (studentChoice) {
            case 1:
                addStudent();
                break;
            case 2:
                editStudent();
                break;
            case 3:
                deleteStudent();
                break;
            case 4:
                addClass();
                break;
            case 5:
                editClass();
                break;
            case 6:
                deleteClass();
                break;
            case 7:
                addSubject();
                break;
            case 8:
                editSubject();
                break;
            case 9:
                deleteSubject();
                break;
            case 10:
                findStudentByID();
                break;
            case 11:
                findStudentByName();
                break;
            case 12:
                findClassByID();
                break;
            case 13:
                findClassByName();
                break;
            case 14:
                findSubjectByName();
                break;
            case 15:
                updateStudentGrade();
                break;

            case 16:
                logout();
                break;
            default:
                System.out.println("Invalid choice. Please try again.\n");
                break;

        }
        managerGreetingSession();

    }



    // add a student
    public void addStudent(String studentID) {
        System.out.println("Enter student's name: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter student's username: ");
        String studentUsername = scanner.nextLine();
        System.out.println("Enter student's password: ");
        String studentPassword = scanner.nextLine();
        readInfo.addStudent(studentID, studentName, studentUsername, studentPassword);
        System.out.println("Student added successfully.");
    }


    public static void logout() {
        System.out.println("You have been logged out successfully.");
        Login login = new Login();

    }
}
