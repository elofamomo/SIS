package org.hust.sis;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Student System Information");
        System.out.println("Your choices:");
        System.out.println("1. Login");
        System.out.println("2. Exit");

        // pass the login step
        Scanner scanner = new Scanner(System.in);
        String choices = scanner.next();
//
//        switch (choices) {
//            case "1":
//                System.out.println("Enter your username: ");
//                String username = scanner.next();
//                System.out.println("Enter your password: ");
//                String password = scanner.next();
////                SIS sisSystem = new SIS(User(Logger.checkLogin(username, password)));
//
//
//
//                // Student enroll
//
//
//        }
        login:
        switch (choices) {
            case "1":

                SisSystem system = new SisSystem();


                //step over the load data process
                //create default data
                system.addUser(new User("Truong The Dung", "20182451", "dungtt76", "dungtt76"));
                system.addClass(new Class("ET2010", "Electronic Technology"));
                system.addClass(new Class("IT2010", "Information Technology"));
                system.addClass(new Class("BE2010", "Biology Engineering"));

                System.out.println("Username:");
                String username = scanner.next();
                System.out.println("Password:");
                String password = scanner.next();

                User user1 = system.login(username, password);
                if (user1 == null) {
                    System.out.println("Invalid username or password");
                    break login;
                }


                while (true) {
                    System.out.println("Your choices:");
                    System.out.println("1. View my information");
                    System.out.println("2. Show enrolled classes");
                    System.out.println("3. Enroll a class");
                    System.out.println("4. Dis-enroll a class");
                    System.out.println("5. Show grades of all classes");

                    String choice = scanner.next();
                    switch (choice) {
                        case "1":
                            system.showInformation(user1);
                            break;
                        case "2":
                            System.out.println("Here list of class you have enrolled:");
                            for (Class i : system.getClassesByUser(user1)) {
                                System.out.println(i.getClassCode());
                            }
                            break;
                        case "3":
                            System.out.println("Here list of classes you can enroll:");
                            for (String i : system.getUnenrolledClassesByUser(user1)) {
                                System.out.println(i);
                            }
                            System.out.println("Please enter the class code you want to enroll:");
                            String enrollWantedClass = scanner.next();
                            if (system.getUnenrolledClassesByUser(user1).contains(enrollWantedClass)){
                                system.enroll(user1 , system.convertClassCodetoClass(enrollWantedClass) );
                                System.out.println("You enroll successfully");
                            }
                            else{
                                System.out.println("The class code you want enroll is invalid");
                            }
//                    system.getClassesByUser(new User("admin", "admin")).forEach(System.out::println);
                            break;
                        case "4":
                            System.out.println("Here list of classes you have enrolled: ");
                            for (Class i : system.getClassesByUser(user1)) {
                                System.out.println(i.getClassCode());
                            }
                            System.out.println("Enter the class code you want to dis-enroll:");
                            String disEnrollClass = scanner.next();
                            if (system.getCLassesCodeByUser(user1).contains(disEnrollClass)){
                                system.disenroll(user1 , system.convertClassCodetoClass(disEnrollClass));
                                System.out.println("You dis-enroll successfully");
                            }else{
                                System.out.println("The class code you want dis-enroll is invalid");
                            }
                            break ;
                        case "5":

//
                            break;
                    }
                }
            case "2":
                System.exit(0);

        }


    }


}
