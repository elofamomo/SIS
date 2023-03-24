package org.hust.sis;

import org.hust.sis.dao.InMemorySisDataAccess;
import org.hust.sis.dao.SisDataAccess;

import java.util.Scanner;

public class Main {

    private static final SisSystem system;


    static {
        SisDataAccess sisDAO = new InMemorySisDataAccess();

        Student student = new Student("Truong The Dung", "20182451", "dungtt76", "dungtt76");
        sisDAO.addUser(student);
        sisDAO.addUser(new Manager("Truong Thi Huong Huong", "11360", "huongdouble", "huongdouble"));

        sisDAO.addClass(new Class("ET2010", sisDAO.convertSubjectCodetoSubject("ET")));
        sisDAO.addClass(new Class("IT2010" , sisDAO.convertSubjectCodetoSubject("IT")));
        sisDAO.addClass(new Class("BE2010", sisDAO.convertSubjectCodetoSubject("BE")));

        sisDAO.addPreviousSemesterClass(new Class("ET2009", sisDAO.convertSubjectCodetoSubject("ET")));
        sisDAO.addPreviousSemesterClass(new Class("IT2009", sisDAO.convertSubjectCodetoSubject("IT")));
        sisDAO.addPreviousSemesterClass(new Class("BE2009", sisDAO.convertSubjectCodetoSubject("BE")));

        sisDAO.enroll(student, sisDAO.convertClassCodetoClass("ET2010"));
        sisDAO.updateStudentGrades(student, sisDAO.convertClassCodetoClass("ET2009"), 10.0f);
        sisDAO.updateStudentGrades(student, sisDAO.convertClassCodetoClass("IT2009"), 9.0f);
        sisDAO.updateStudentGrades(student, sisDAO.convertClassCodetoClass("BE2009"), 8.0f);

        system = new SisSystem(sisDAO);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to Student System Information");
            System.out.println("Your choices:");
            System.out.println("1. Login");
            System.out.println("2. Exit");

            // pass the login step
            Scanner scanner = new Scanner(System.in);
            String choices = scanner.next();


            login:
            switch (choices) {
                case "1":
                    System.out.println("Username:");
                    String username = scanner.next();
                    System.out.println("Password:");
                    String password = scanner.next();

                    User user1 = system.login(username, password);


                    if (user1 == null) {
                        System.out.println("Invalid username or password");
                        break;
                    }
                    if (user1 instanceof Student) {

                        // create default previous semester grades data '
                        Student student = (Student) user1;


                        while (true) {
                            System.out.println("Your choices:");
                            System.out.println("1. View my information");
                            System.out.println("2. Show enrolled classes");
                            System.out.println("3. Enroll a class");
                            System.out.println("4. Dis-enroll a class");
                            System.out.println("5. Show grades of all classes");
                            System.out.println("6. Logout");

                            String choice = scanner.next();

                            switch (choice) {
                                case "1":
                                    system.showInformation(student);
                                    break;
                                case "2":
                                    System.out.println("Here list of class you have enrolled:");
                                    if (system.getClassesByUser(student) != null) {
                                        for (Class i : system.getClassesByUser(student)) {
                                            System.out.println(i.getClassCode());
                                        }
                                    }


                                    break;
                                case "3":
                                    System.out.println("Here list of classes you can enroll:");
                                    for (String i : system.getUnenrolledClassesByUser(student)) {
                                        System.out.println(i);
                                    }
                                    System.out.println("Please enter the class code you want to enroll:");
                                    String enrollWantedClass = scanner.next();
                                    if (system.getUnenrolledClassesByUser(student).contains(enrollWantedClass)) {
                                        system.enroll(student, system.convertClassCodetoClass(enrollWantedClass));
                                        System.out.println("You enroll successfully");
                                    } else {
                                        System.out.println("The class code you want enroll is invalid");
                                    }
//                    system.getClassesByUser(new User("admin", "admin")).forEach(System.out::println);
                                    break;
                                case "4":
                                    System.out.println("Here list of classes you have enrolled: ");
                                    for (Class i : system.getClassesByUser(student)) {
                                        System.out.println(i.getClassCode());
                                    }
                                    System.out.println("Enter the class code you want to dis-enroll:");
                                    String disEnrollClass = scanner.next();
                                    if (system.getCLassesCodeByUser(student).contains(disEnrollClass)) {
                                        system.disenroll(student, system.convertClassCodetoClass(disEnrollClass));
                                        System.out.println("You dis-enroll successfully");
                                    } else {
                                        System.out.println("The class code you want dis-enroll is invalid");
                                    }
                                    break;
                                case "5":
                                    System.out.println("Your previous term results:");
                                    system.showGradesOfAStudent(student);
                                    break;


//5
                                case "6":
                                    break login;
                            }
                        }
                    }
                    if (user1 instanceof Manager) {
                        Manager manager = (Manager) user1;

                        while (true) {
                            System.out.println("Your choices:");
                            System.out.println("1. Add a student");
                            System.out.println("2. Edit a student information");
                            System.out.println("3. Delete a student");
                            System.out.println("4. Add a new class");
                            System.out.println("5. Edit a class information");
                            System.out.println("6. Delete a class");
                            System.out.println("7. Add a new subject");
                            System.out.println("8. Edit a subject ");
                            System.out.println("9. Delete a subject");
                            System.out.println("10.Find the student by student ID");
                            System.out.println("11.Find the student by student name");
                            System.out.println("12.Find the student by the class");
                            System.out.println("13.Find a class by the class ID");
                            System.out.println("14.Find subject by the subject ID");
                            System.out.println("15.Log out");

                            String choice = scanner.next();
                            scanner.nextLine();


                            switch (choice) {
                                case "1":
                                    System.out.println("Please fill the student info");
                                    System.out.print("Student name:");
                                    String newStudentName = scanner.nextLine();
                                    System.out.print("Student ID:");
                                    String newStudentID = scanner.next();
                                    System.out.println("Student username:");
                                    String newStudentUsername = scanner.next();
                                    System.out.println("Student password:");
                                    String newStudentPassword = scanner.next();
                                    if (system.checkExistingUser(newStudentID, newStudentUsername)) {
                                        system.addUser(new Student(newStudentName, newStudentID, newStudentUsername, newStudentPassword));
                                    }
                                    break;
                                case "2":
                                    System.out.println("Please select the student you want to edit");
                                    System.out.println("1. I want to find student to edit by student ID");
                                    System.out.println("2. I want to find student to edit by student name");

                                    String findMethod = scanner.next();

                                    switch (findMethod) {
                                        case "1":
                                            System.out.println("Student ID:");
                                            String studentID = scanner.next();
                                            scanner.nextLine();
                                            Student student1 = system.findStudentByID(studentID);
                                            if (student1 == null) {
                                                System.out.println("The student ID you want to edit is invalid");
                                                break;
                                            }
                                            System.out.println("The student info now :");
                                            System.out.println("Student name: " + student1.getName());
                                            System.out.println("Student ID: " + student1.getID());


                                            System.out.print("New student name:");
                                            String newStudentName1 = scanner.nextLine();
//                                        scanner.nextLine();

                                            System.out.print("New student ID:");
                                            String newStudentID1 = scanner.next();
                                            if (system.checkExistingUser(newStudentID1 , student1.getUsername() )){
                                            student1.setName(newStudentName1);
                                            student1.setID(newStudentID1);}
                                            else {
                                                System.out.println("The student ID is existing");
                                            }
                                            break;

                                        case "2":
                                            System.out.println("Student name");
                                            scanner.nextLine();
                                            String studentName = scanner.nextLine();
                                            Student student2 = system.findStudentByName(studentName);
                                            if (student2 == null) {
                                                System.out.println("The student name you want to edit is invalid");
                                                break;
                                            }
                                            System.out.println("The student info now :");
                                            System.out.println("Student name: " + student2.getName());
                                            System.out.println("Student ID: " + student2.getID());
                                            System.out.println("New student name:");
//                                        scanner.nextLine();
                                            String newStudentName2 = scanner.nextLine();
                                            System.out.println("New student ID:");
                                            String newStudentID2 = scanner.next();
                                            student2.setName(newStudentName2);
                                            student2.setID(newStudentID2);
                                            break;


                                    }
                                    break;
                                case "3":
                                    System.out.println("Please select the student you want to delete");
                                    System.out.println("1. I want to find student to delete by student ID");
                                    System.out.println("2. I want to find student to delete by student name");

                                    String findMethod1 = scanner.next();

                                    switch (findMethod1) {
                                        case "1":
                                            System.out.println("Student ID:");
                                            String studentID = scanner.next();
                                            scanner.nextLine();
                                            Student student1 = system.findStudentByID(studentID);
                                            if (student1 == null) {
                                                System.out.println("The student ID you want to delete is invalid");
                                                break;
                                            }
                                            System.out.println("The student with these info will be deleted:" + student1.getName() + " " + student1.getID());
                                            system.deleteStudent(student1);
                                            break;
                                        case "2":
                                            System.out.println("Student name");
                                            scanner.nextLine();
                                            String studentName = scanner.nextLine();
                                            Student student2 = system.findStudentByName(studentName);
                                            if (student2 == null) {
                                                System.out.println("The student name you want to delete is invalid");
                                                break;
                                            }
                                            System.out.println("The student with these info will be deleted:" + student2.getName() + " " + student2.getID());
                                            system.deleteStudent(student2);
                                            break;
                                    }
                                    break;
                                case "4":
                                    System.out.println("Fill the new class info:");
                                    System.out.println("Class ID:");
                                    String newClassID = scanner.next();
                                    Subject subject = system.convertSubjectCodetoSubject(newClassID.substring(0, 2));
                                    if (subject != null && system.checkExistingClassId(newClassID)) {
                                        system.addClass(new Class(newClassID, subject));
                                    } else {
                                        System.out.println("Invalid subject code or the class ID is incorrect format");
                                    }
                                    break;
                                case "5":
                                    System.out.println("Fill the class code you want to edit:");
                                    String classID = scanner.next();
                                    Class class1 = system.findClassByCode(classID);

                                    if (class1 == null) {
                                        System.out.println("The class code you want to edit is invalid");
                                        break;
                                    }
                                    System.out.println("The class info now:");
                                    System.out.println("Class ID: " + class1.getClassCode());
                                    System.out.println("Class subject: " + class1.getClassSubject().getSubjectName());
                                    System.out.println("New class ID:");
                                    String newClassID1 = scanner.next();
                                    System.out.println("New class subject:");
                                    Subject newClassSubject1 = system.convertSubjectCodetoSubject(newClassID1.substring(0, 2));
                                    if (newClassSubject1 != null && system.checkExistingClassId(newClassID1)) {
                                        class1.setClassCode(newClassID1);
                                        class1.setClassSubject(newClassSubject1);
                                    }else {
                                        System.out.println("This class ID is existing");}
                                    break;

                                case "6":
                                    System.out.println("Fill the class code you want to delete:");
                                    String classID1 = scanner.next();
                                    Class class2 = system.findClassByCode(classID1);

                                    if (class2 == null) {
                                        System.out.println("The class code you want to delete is invalid");
                                        break;
                                    }
                                    System.out.println("The class with these info will be deleted:" + class2.getClassCode() + " " + class2.getClassSubject());
                                    system.deleteClass(class2);
                                    break;

                                case "7":
                                    System.out.println("Please fill the subject you want to add:");
                                    System.out.println("Subject code:");
                                    String newSubjectCode = scanner.next();
                                    System.out.println("Subject name:");
                                    scanner.nextLine();
                                    String newSubjectName = scanner.nextLine();
                                    if (system.checkExistingSubjectCode(newSubjectCode) && system.checkExistingSubjectName(newSubjectName)) {
                                        system.addSubject(new Subject(newSubjectCode, newSubjectName));
                                    } else {
                                        System.out.println("The subject you want to add may be existing");
                                    }
                                    break;

                                case "8":
                                    System.out.println("Here all the subjects:");
                                    system.showAllSubjects();

                                    System.out.println("Select the subject you want to edit by fill subject code:");
                                    String subjectCode = scanner.next();
                                    Subject subject1 = system.findSubjectByCode(subjectCode);
                                    if (subject1 == null) {
                                        System.out.println("The subject code you want to edit is invalid");
                                        break;
                                    }
                                    System.out.println("The subject info now:");
                                    System.out.println("Subject code: " + subject1.getSubjectCode());
                                    System.out.println("Subject name: " + subject1.getSubjectName());
                                    System.out.println("New subject code:");
                                    String newSubjectCode1 = scanner.next();
                                    subject1.setSubjectCode(newSubjectCode1);
                                    System.out.println("New subject name:");
                                    scanner.nextLine();
                                    String newSubjectName1 = scanner.nextLine();
                                    subject1.setSubjectName(newSubjectName1);
                                    //TODO: Need to edit class subject when the subject info changed
                                    break;

                                case "9":
                                    System.out.println("Here all the subjects:");
                                    system.showAllSubjects();

                                    System.out.println("Select the subject you want to delete by fill subject code:");
                                    String subjectCode2 = scanner.next();
                                    Subject subject2 = system.findSubjectByCode(subjectCode2);
                                    if (subject2 == null) {
                                        System.out.println("The subject code you want to delete is invalid");
                                        break;
                                    }
                                    System.out.println("The subject with these info will be deleted:" + subject2.getSubjectCode() + " - " + subject2.getSubjectName());
                                    system.deleteSubject(subject2);
                                    //TODO: Need to delete class subject when the subject info changed
                                    break;

                                case "10":
                                    System.out.println("Please fill the student ID");
                                    String studentID = scanner.next();
                                    Student student1 = system.findStudentByID(studentID);
                                    if (student1 == null) {
                                        System.out.println("The student ID is invalid");
                                        break;
                                    }
                                    System.out.println("This student information:");
                                    System.out.println("Student name: " + student1.getName());
                                    System.out.println("Student ID: " + student1.getID());
                                    break;

                                case "11":
                                    System.out.println("Please fill the student name");
                                    String studentName = scanner.nextLine();
                                    Student student2 = system.findStudentByName(studentName);
                                    if (student2 == null) {
                                        System.out.println("The student name is invalid");
                                        break;
                                    }
                                    System.out.println("This student information:");
                                    System.out.println("Student name: " + student2.getName());
                                    System.out.println("Student ID: " + student2.getID());
                                    break;

                                case "12":
                                    System.out.println("Please fill the class code you want to find student");
                                    String classCode = scanner.next();
                                    Class class3 = system.findClassByCode(classCode);
                                    if (class3 == null) {
                                        System.out.println("The class code is invalid");
                                        break;
                                    }
                                    for (Student students : system.findStudentsByClass(class3)) {
                                        int studentIndex = 1 ;
                                        System.out.println("Number" + studentIndex++ + " :");
                                        System.out.println("Student name: " + students.getName());
                                        System.out.println("Student ID: " + students.getID());
                                    }
                                    break;

                                case "13":
                                    System.out.println("Please fill the class code you want to find");
                                    String classCode1 = scanner.next();
                                    Class class4 = system.findClassByCode(classCode1);
                                    if (class4 == null) {
                                        System.out.println("The class code is invalid");
                                        break;
                                    }
                                    System.out.println("This class information:");
                                    System.out.println("Class code: " + class4.getClassCode());
                                    System.out.println("Class subject: " + class4.getClassSubject().getSubjectName());
                                    break;

                                case "14":
                                    System.out.println("Please fill the subject code you want to find");
                                    String subjectCode1 = scanner.next();
                                    Subject subject3 = system.findSubjectByCode(subjectCode1);
                                    if (subject3 == null) {
                                        System.out.println("The subject code is invalid");
                                        break;
                                    }
                                    System.out.println("This subject information:");
                                    System.out.println("Subject code: " + subject3.getSubjectCode());
                                    System.out.println("Subject name: " + subject3.getSubjectName());
                                    break;
                                case "15":
                                    break login;
                            }
                        }
                    }
                    break;
                case "2":
                    System.exit(0);


            }


        }

    }
}
