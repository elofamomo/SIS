package org.hust.sis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SisSystem {
    private List<User> users;
    private List<Class> classes;
    private Map<String,String> classesToSubject;

    private Map<User, List<Class>> enrollment;

    public SisSystem() {
        this.users = new ArrayList<>();
        this.classes = new ArrayList<>();
        this.classesToSubject = new HashMap<>();
        this.enrollment = new HashMap<>();
    }



    public void showInformation(User user)
    {
        System.out.println("Your information");
        System.out.println("Name: " + user.getName());
        System.out.println("ID: " + user.getID());
    }
    public void addUser(User user) {
        this.users.add(user);
    }

    public void addClass(Class class1 ) {
        this.classes.add(class1 );
    }


    public List<User> getUsers() {
        return this.users;
    }

    public User login(String username, String password) {
        for (User user : this.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

//    public void showClasses(User user) {
//        for (String classCode : this.classes) {
//            System.out.println(classCode);
//        }
//    }
    public void showUnenrolledClasses(User user){

    }
    public void showEnrolledClasses(User user) {

    }
    public List<String> getUnenrolledClassesByUser(User user) {
        List<String> unEnrolledClasses = new ArrayList<>();
        for(Class i :  classes){
            if (!enrollment.getOrDefault(user, new ArrayList<>()).contains(i)){
                unEnrolledClasses.add(i.getClassCode());
            }
        }
        return unEnrolledClasses;
    }

    public void enroll(User user, Class class1) {
        enrollment.computeIfAbsent(user, k -> new ArrayList<>()).add(class1);
    }

    public void disenroll (User user , Class class1) {
        enrollment.computeIfAbsent(user, k -> new ArrayList<>()).remove(class1);
    }

    public List<Class> getClassesByUser(User user) {

        return enrollment.getOrDefault(user , new ArrayList<>());
    }

    public List<String> getCLassesCodeByUser(User user){
        List<String> classesIDByUser = new ArrayList<>();
        for(Class i : enrollment.getOrDefault(user, new ArrayList<>())){
            classesIDByUser.add(i.getClassCode());
        }
        return classesIDByUser;
    }

    public Class convertClassCodetoClass(String classCode){
        for ( Class i : classes) {
            if(i.getClassCode().equals(classCode));
            return i;
        }
        return null;
    }

}
