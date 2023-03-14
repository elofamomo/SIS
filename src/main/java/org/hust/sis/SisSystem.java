package org.hust.sis;

import org.hust.sis.dao.SisDataAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SisSystem {

    private SisDataAccess sisDAO;

    public SisSystem(SisDataAccess sisDAO) {
        this.sisDAO = sisDAO;
    }
    public void showInformation(User user) {
        System.out.println("Your information");
        System.out.println("Name: " + sisDAO.getUserName(user));
        System.out.println("ID: " + sisDAO.getUserID(user));
    }
    public void addUser(User user) {
        // check abc
         this.sisDAO.addUser(user);
    }

    public void addClass(Class clazz) {
        // check ...
        this.sisDAO.addClass(clazz);
    }


    public User login(String username, String password) {
        for (User user : sisDAO.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }


    public void showUnenrolledClasses(User user) {

    }

    public void showEnrolledClasses(User user) {

    }

    public List<String> getUnenrolledClassesByUser(User user) {
        return sisDAO.getUnenrolledClassesByUser(user);
    }

    public void enroll(User user, Class class1) {
        sisDAO.enroll(user, class1);
    }

    public void disenroll(User user, Class class1) {
        sisDAO.disenroll(user, class1);
    }

    public List<Class> getClassesByUser(User user) {

        return sisDAO.getClassesByUser(user);
    }

    public List<String> getCLassesCodeByUser(User user) {
        return sisDAO.getClassesCodeByUser(user);
    }


    public Map<Class, Float> getGradesOfAStudent(Student student) {

        return student.getGrades();
    }

    public void updateStudentGrades(Student student, Class class1, Float grade) {


    }

    public Subject convertSubjectNameToSubject(String subjectName) {
        return sisDAO.convertSubjectNameToSubject(subjectName);
    }

    public Subject convertSubjectCodeToSubject(String subjectCode) {
       return sisDAO.convertSubjectCodeToSubject(subjectCode);
    }

    public Class convertClassCodetoClass(String classCode1) {
        return sisDAO.convertClassCodetoClass(classCode1);
    }

    public void showGradesOfAStudent(Student student) {
        for (Map.Entry<String, Float> entry : sisDAO.getGradesOfAStudent(student).entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

//    public void addPreviousSemesterClass(Class class1) {
//        previousSemesterClasses.add(class1);
//    }

    public Student findStudentByID(String id) {
        for (User user : sisDAO.getUsers()) {
            if (user instanceof Student) {
                if (user.getID().equals(id)) {
                    return (Student) user;
                }
            }
        }
        return null;
    }

    public Class findClassByCode(String code) {
        return sisDAO.findClassByCode(code);
    }

    public Student findStudentByName(String name) {
        for (User user : sisDAO.getUsers()) {
            if (user instanceof Student) {
                if (user.getName().equals(name)) {
                    return (Student) user;
                }
            }
        }
        return null;
    }

    public void deleteStudent(Student student) {
        // TODO: sua tai DAO
        sisDAO.deleteStudent(student);
    }
//
    public void deleteClass(Class class1) {
        sisDAO.deleteClass(class1);
    }

    public void addSubject(Subject subject) {
        sisDAO.addSubject(subject);
    }

    public void deleteSubject(Subject subject) {
        sisDAO.deleteSubject(subject);
    }

    public void showAllSubjects() {
      sisDAO.showAllSubjects();
    }

    public Subject findSubjectByCode(String code) {
        return sisDAO.findSubjectByCode(code);
    }


    public List<Student> findStudentsByClass(Class class1) {
        return sisDAO.findStudentByClass(class1);
    }


//    public List<Class> getClassesListByASubject(Subject subject) {
//        List<Class> classesBySubject = new ArrayList<>();
//        for (Class class1 : classes) {
//            if (class1.getClassSubject().equals(subject)) {
//                classesBySubject.add(class1);
//            }
//        }
//        return classesBySubject;
//    }


}
