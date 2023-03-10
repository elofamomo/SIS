package org.example;

import java.util.Scanner;












public class StudentInformationSystem {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        // new logging session
        Login loginStart = new Login();

    }



//    private static void managerMenu() {
//        while (true) {
//            int choice = showManagerMenu();
//
//            switch (choice) {
//                case 1:
//                    addStudent();
//                    break;
//                case 2:
//                    editStudent();
//                    break;
//                case 3:
//                    deleteStudent();
//                    break;
//                case 4:
//                    addSubject();
//                    break;
//                case 5:
//                    editSubject();
//                    break;
//                case 6:
//                    deleteSubject();
//                    break;
//                case 7:
//                    addClass();
//                    break;
//                case 8:
//                    editClass();
//                    break;
//                case 9:
//                    deleteClass();
//                    break;
//                case 10:
//                    findStudentById();
//                    break;
//                case 11:
//                    findStudentByName();
//                    break;
//                case 12:
//                    findStudentByClass();
//                    break;
//                case 13:
//                    findSubject();
//                    break;
//                case 14:
//                    findClass();
//                    break;
//                case 15:
//                    updateGrade();
//                    break;
//                case 16:
//
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.\n");
//                    break;
//            }
//        }
//    }


    private static int showManagerMenu() {
        System.out.println("\nManager Menu:");
        System.out.println("1. Add Student");
        System.out.println("2. Edit Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Add Subject");
        System.out.println("5. Edit Subject");
        System.out.println("6. Delete Subject");
        System.out.println("7. Add Class");
        System.out.println("8. Edit Class");
        System.out.println("9. Delete Class");
        System.out.println("10. Find Student by ID");
        System.out.println("11. Find Student by Name");
        System.out.println("12. Find Student by Class");
        System.out.println("13. Find Subject");
        System.out.println("14. Find Class");
        System.out.println("15. Update Grade");
        System.out.println("16. Logout");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;


    }

    public static void addStudent() {

    }

    public static void editStudent() {

    }

    public static void deleteStudent() {

    }

    public static void addSubject() {

    }

    public static void editSubject() {

    }

    public static void deleteSubject() {

    }

    public static void addClass() {

    }

    public static void editClass() {

    }

    public static void deleteClass() {

    }

    public static void findStudentById() {

    }

    public static void findStudentByName() {

    }

    public static void findStudentByClass() {

    }

    public static void findSubject() {

    }

    public static void findClass() {

    }

    public static void updateGrade() {

    }



    private static void studentMenu(Student student) {
        while (true) {
            int choice = showStudentMenu();

            switch (choice) {
                case 1:
                    viewStudentInfo(student);
                    break;
                case 2:
                    viewStudentGrades(student);
                    break;
                case 3:
                    viewStudentClass(student);
                    break;
                case 4:
                    registerClass(student);
                    break;
                case 5:
                    unregisterClass(student);
                    break;

                case 6:

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        }
    }

    public static int showStudentMenu () {
        System.out.println("\nStudent Menu:");
        System.out.println("1. View Student Information");
        System.out.println("2. View Student Grades");
        System.out.println("3. View Student Schedule");
        System.out.println("4. Register Subject");
        System.out.println("5. Unregister Subject");
        System.out.println("6. Logout");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public static void viewStudentInfo(Student student) {

    }

    public static void viewStudentGrades(Student student) {

    }

    public static void viewStudentClass(Student student) {

    }

    public static void registerClass(Student student) {

    }

    public static void unregisterClass(Student student) {

    }


}