package org.example;

import java.util.*;

class Student {
    private Scanner scanner = new Scanner(System.in);
    private static String id;
    private static String name;
    private static String username;
    private static String password;
    private static List<String> registeredClassName;
    private static List<String> registeredSubjectName;
    private static Map<String, Float> studentGrades = new HashMap<>();
    private static List<String> registableClassName = new ArrayList<>();
    private ArrayList<Subject> subjects = new ArrayList<>();

    static ReadAndSaveData readStudentInfo = new ReadAndSaveData();

    public Student(String id) {
        this.id = id;

        this.name = readStudentInfo.getStudentInfo(id).get(0);
        this.username = readStudentInfo.getStudentInfo(id).get(1);
        this.password = readStudentInfo.getStudentInfo(id).get(2);
        this.registeredClassName = readStudentInfo.readClassesOfAStudent(id);
        this.registeredSubjectName = readStudentInfo.readSubjectsOfAStudent(registeredClassName);
        this.studentGrades = readStudentInfo.readGradesOfAStudent(registeredClassName);
        this.registableClassName = readStudentInfo.getClassesNameList();
        for (String i : registeredClassName) {
            this.registableClassName.remove(i);
        }



    }

    public void studentGreetingSession() {
        System.out.println("");
        System.out.println("");
        System.out.printf("");
        System.out.println("Hi " + this.name);
        System.out.println("What do you want to do?");
        System.out.println("1. View my information");
        System.out.println("2. View my registered classes");
        System.out.println("3. Register a class");
        System.out.println("4. Unregister a class");
        System.out.println("5. View my study results");
        System.out.println("6. Logout");
        doStudentSession();
    }

    public void doStudentSession() {
        System.out.println("Select your choice: ");
        int studentChoice = scanner.nextInt();

        switch (studentChoice) {
            case 1:
                viewStudentInfo();
                break;
            case 2:
                viewStudentClass();
                break;
            case 3:
                registerClass();
                break;
            case 4:
                unregisClass();
                break;
            case 5:
                viewStudentGrades();
                break;

            case 6:
                logOutSession();
                break;
            default:
                System.out.println("Invalid choice. Please try again.\n");
                break;

        }
        studentGreetingSession();


    }

    public static void viewStudentClass() {
        System.out.println("Your registered class :");
        for (String i : registeredClassName) {
            System.out.println(i + "-" + registeredSubjectName.get(registeredClassName.indexOf(i)));
        }


    }


    public static void registerClass() {
        // list the class name and subject of all class that the student can regis
        System.out.println("Here the list of all classes you can register:");
        for (String i : registableClassName) {
            for (String j : ReadAndSaveData.getClassesNameList()) {
                if (i.equals(j)) {
                    System.out.println(i + "-" + ReadAndSaveData.getClassesSubjectNameList().get(ReadAndSaveData.getClassesNameList().indexOf(j)));
                }
            }

        }

        System.out.println("Enter the class you want to register: ");
        Scanner scanner = new Scanner(System.in);
        String regisClassName = scanner.nextLine();

        if ( !registableClassName.contains(regisClassName))
        {
            System.out.println("You can't register this class or this class not exist!");

        }
        else {
            Class newClass = new Class(regisClassName);
            newClass.addStudent(id);
            registeredClassName.add(regisClassName);
            // subject of the registered class
            registeredSubjectName.add(readStudentInfo.getClassesSubjectNameList().get(readStudentInfo.getClassesNameList().indexOf(regisClassName)));
            registableClassName.remove(regisClassName);
            System.out.println("You registered this class successfully!");
        }


    }

    public static void unregisClass() {
        // list the class name and subject of all class that the student can regis
//        System.out.println("Here the list of all classes you can unregister:");
//        System.out.println(ReadAndSaveData.getClassesNameList());
//        for (String i : registeredClassName) {
//            for (String j : ReadAndSaveData.getClassesNameList()) {
//                if (i.equals(j)) {
//                    System.out.println(i + "-" + ReadAndSaveData.getClassesSubjectNameList().get(ReadAndSaveData.getClassesNameList().indexOf(j)));
//                }
//            }
//
//        }

        System.out.println("Enter the class you want to unregister: ");
        Scanner scanner = new Scanner(System.in);
        String unregisClassName = scanner.nextLine();

        if (!registeredClassName.contains(unregisClassName)) {
            System.out.println("You can't unregister this class or this class not exist!");

        } else {
            Class newClass = new Class(unregisClassName);
            newClass.removeStudent(id);
            int unregisteredIndex = registeredClassName.indexOf(unregisClassName);
            registeredClassName.remove(unregisClassName);
            System.out.println(registeredSubjectName);
            // subject of the registered class
            registeredSubjectName.remove(unregisteredIndex);
            registableClassName.add(unregisClassName);
            System.out.println("You unregistered this class successfully!");
        }
    }

    public static void viewStudentGrades() {
        System.out.println("Your grades of all classes:");
        for (String i : registeredClassName) {
            System.out.println(i + "-" + registeredSubjectName.get(registeredClassName.indexOf(i)) + ": " + studentGrades.get(i));
        }


    }

    public void viewStudentInfo() {
        System.out.println("Your Information:");
        System.out.println("Name: " + this.name);
        System.out.println("ID: " + this.id);
        System.out.println("Username: " + this.username);
        System.out.println("Password: " + this.password);
    }

    public void logOutSession() {
        System.out.println("You have logged out successfully!");
        Login login = new Login();
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }



    public String getUsername() {
        return username;
    }



    public String getPassword() {
        return password;
    }


    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public void unsetSubjects() {
        this.subjects = null;
    }

}
