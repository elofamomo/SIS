package org.example;

public class Manager {
    private String managerName;
    private String managerID;
    private String managerUsername;
    private String managerPassword;

     Manager(String managerID ) {
        this.managerID = managerID;

    }
    public static void logout() {
        System.out.println("You have been logged out");

    }
}
