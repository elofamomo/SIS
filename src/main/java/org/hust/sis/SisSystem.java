package org.hust.sis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SisSystem {
    private List<User> users;
    private List<Class> classes;
    private List<Subject> subjects;

    private List<Class> previousSemesterClasses;

    private Map<User, List<Class>> achievedClasses;


    private Map<User, List<Class>> enrollment;


    public SisSystem() {
        this.users = new ArrayList<>();
        this.classes = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.enrollment = new HashMap<>();
        this.achievedClasses = new HashMap<>();
        this.previousSemesterClasses = new ArrayList<>();
    }


    public void showInformation(User user) {
        System.out.println("Your information");
        System.out.println("Name: " + user.getName());
        System.out.println("ID: " + user.getID());

    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addClass(Class class1) {
        this.classes.add(class1);
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
    public void showUnenrolledClasses(User user) {

    }

    public void showEnrolledClasses(User user) {

    }

    public List<String> getUnenrolledClassesByUser(User user) {
        List<String> unEnrolledClasses = new ArrayList<>();
        for (Class i : classes) {
            if (!enrollment.getOrDefault(user, new ArrayList<>()).contains(i)) {
                unEnrolledClasses.add(i.getClassCode());
            }
        }
        return unEnrolledClasses;
    }

    public void enroll(User user, Class class1) {
        enrollment.computeIfAbsent(user, k -> new ArrayList<>()).add(class1);
    }

    public void disenroll(User user, Class class1) {
        enrollment.computeIfAbsent(user, k -> new ArrayList<>()).remove(class1);
    }

    public List<Class> getClassesByUser(User user) {

        return enrollment.getOrDefault(user, new ArrayList<>());
    }

    public List<String> getCLassesCodeByUser(User user) {
        List<String> classesIDByUser = new ArrayList<>();
        for (Class i : enrollment.getOrDefault(user, new ArrayList<>())) {
            classesIDByUser.add(i.getClassCode());
        }
        return classesIDByUser;
    }

    public Class convertClassCodetoClass(String classCode1) {
        List<Class> allClasses = new ArrayList<>();
        allClasses.addAll(classes);
        allClasses.addAll(previousSemesterClasses);
        for (Class i : allClasses) {
            String j = i.getClassCode();
            if (j.equals(classCode1)) {
                return i;
            }

        }
        return null;
    }

    public Map<Class, Float> getGradesOfAStudent(Student student) {

        return student.getGrades();
    }

    public void updateStudentGrades(Student student, Class class1, Float grade) {
        student.updateGradesOfAClass(class1, grade);
    }

    public void showGradesOfAStudent(Student student) {
        Map<Class, Float> grades = student.getGrades();
        for (Map.Entry<Class, Float> entry : grades.entrySet()) {
            System.out.println(entry.getKey().getClassCode() + " - " + entry.getKey().getClassSubject() + " " + entry.getValue());
        }
    }

    public void addPreviousSemesterClass(Class class1) {
        previousSemesterClasses.add(class1);
    }

    public Student findStudentByID(String id) {
        for (User user : users) {
            if (user instanceof Student) {
                if (user.getID().equals(id)) {
                    return (Student) user;
                }
            }
        }
        return null;
    }

    public Class findClassByCode(String code) {
        for (Class class1 : classes) {
            if (class1.getClassCode().equals(code)) {
                return class1;
            }
        }
        return null;
    }

    public Student findStudentByName(String name) {
        for (User user : users) {
            if (user instanceof Student) {
                if (user.getName().equals(name)) {
                    return (Student) user;
                }
            }
        }
        return null;
    }

    public void deleteStudent(Student student) {
        users.remove(student);
    }

    public void deleteClass(Class class1) {
        classes.remove(class1);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void deleteSubject(Subject subject) {
        subjects.remove(subject);
    }

    public void showAllSubjects() {
        for (Subject subject : subjects) {
            System.out.println(subject.getSubjectCode() + " - " + subject.getSubjectName());


        }
    }

    public Subject findSubjectByCode(String code) {
        for (Subject subject : subjects) {
            if (subject.getSubjectCode().equals(code)) {
                return subject;
            }
        }
        return null;
    }


    public List<Student> findStudentsByClass(Class class1) {
        List<Student> students2 = new ArrayList<>();
        for (User user : enrollment.keySet()) {
            if (user instanceof Student) {
                if (enrollment.get(user).contains(class1)) {
                    students2.add((Student) user);
                }
            }
        }


        return students2;
    }


}
