package org.hust.sis.dao;

import org.hust.sis.*;
import org.hust.sis.Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemorySisDataAccess implements SisDataAccess {
    private List<User> users = new ArrayList<>();
    private List<Class> classes = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();
    private List<Grades> grades = new ArrayList<>() ;
    private List<Class> previousSemesterClasses = new ArrayList<>();
    private Map<User, List<Class>> enrollment = new HashMap<>();
    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void deleteStudent(Student student) {
        this.users.remove(student);

    }

    @Override
    public Class findClassByCode(String code) {
        for (Class class1 : classes) {
            if (class1.getClassCode().equals(code)) {
                return class1;
            }
        }
        return null;
    }

    @Override
    public void addClass(Class clazz) {
        this.classes.add(clazz);
    }

    @Override
    public void deleteClass(Class class1) {
        this.classes.remove(class1);
    }

    @Override
    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    @Override
    public void showAllSubjects() {
        for (Subject subject : subjects) {
            System.out.println(subject.getSubjectCode() + " - " + subject.getSubjectName());
        }
    }

    @Override
    public Subject findSubjectByCode(String code) {
        for (Subject subject : subjects) {
            if (subject.getSubjectCode().equals(code)) {
                return subject;
            }
        }
        return null;
    }


    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void deleteSubject(Subject subject) {
        subjects.remove(subject);
    }

    @Override
    public List<Student> findStudentsByClass(Class class1) {
        return null;
    }

    @Override
    public Subject convertSubjectNameToSubject(String subjectName) {
        for (Subject subject : subjects) {
            if (subject.getSubjectName().equals(subjectName)) {
                return subject;
            }
        }
        return null;
    }

    @Override
    public Subject convertSubjectCodeToSubject(String subjectCode) {
        for (Subject subject : subjects) {
            if (subject.getSubjectCode().equals(subjectCode)) {
                return subject;
            }
        }
        return null;
    }


    @Override
    public List<Class> getClassesByUser(User user) {
        return enrollment.getOrDefault(user, new ArrayList<>());
    }

    @Override
    public Subject convertSubjectCodetoSubject(String subjectCode) {
        return null;
    }

    @Override
    public void updateStudentGrades(Student student, Class class1, Float grade) {
        this.grades.add(new Grades(class1 , student, grade));
    }

    public Map<String, Float> getGradesOfAStudent(Student student) {
        Map < String , Float > gradesOfAStudent = new HashMap<>();
        for (  Grades grade : grades){
            if( grade.getStudent() ==  student){
                gradesOfAStudent.put( grade.getClass1().getClassCode() , grade.getGradePoint() );
            }
        }
        return gradesOfAStudent;
    }

    @Override
    public Class convertClassCodetoClass(String classCode) {
        List<Class> allClasses = new ArrayList<>();
        allClasses.addAll(classes);
        allClasses.addAll(previousSemesterClasses);
        for (Class i : allClasses) {
            String j = i.getClassCode();
            if (j.equals(classCode)) {
                return i;
            }
        }
        return null;
    }
            public List<String> getClassesCodeByUser(User user) {
        List<String> classesIDByUser = new ArrayList<>();
        for (Class i : enrollment.getOrDefault(user, new ArrayList<>())) {
            classesIDByUser.add(i.getClassCode());
        }
        return classesIDByUser;
    }

    @Override
    public String getUserName(User user) {
        return user.getName();
    }

    @Override
    public String getUserID(User user) {
        return user.getID();
    }


    @Override
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
        this.enrollment.computeIfAbsent(user, k -> new ArrayList<>()).add(class1);
    }

    public void disenroll(User user, Class class1) {
        this.enrollment.computeIfAbsent(user, k -> new ArrayList<>()).remove(class1);
    }
    public void addPreviousSemesterClass(Class class1) {
        previousSemesterClasses.add(class1);
    }


}
