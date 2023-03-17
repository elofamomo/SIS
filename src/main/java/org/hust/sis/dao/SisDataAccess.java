package org.hust.sis.dao;

import org.hust.sis.Class;
import org.hust.sis.Student;
import org.hust.sis.Subject;
import org.hust.sis.User;

import java.util.List;
import java.util.Map;

public interface SisDataAccess {
    void addUser(User user);
    void deleteStudent(Student student);
    Class findClassByCode(String classCode);

    void addClass(Class clazz);
    void deleteClass(Class class1);

    void addSubject(Subject subject);
    void showAllSubjects();

    Subject findSubjectByCode(String code);

    void enroll(User user, Class class1);

    void disenroll(User user, Class class1);

    void addPreviousSemesterClass(Class class1);

    Map<String, Float> getGradesOfAStudent(Student student);

    List<User> getUsers();
    List<Class> getClasses();
    List<Subject> getSubjects();

    void deleteSubject(Subject subject);

    List<Student> findStudentsByClass(Class class1);
    void addGrades(Student student, Class class1, Float grade);

    Subject convertSubjectNameToSubject(String subjectName);


    List<Student> findStudentByClass(Class class1);

    List<Class> getClassesByUser(User user);

    Subject convertSubjectCodetoSubject(String subjectCode);

    void updateStudentGrades(Student student, Class class1, Float grade);

    Class convertClassCodetoClass(String classCode);

    String getUserName(User user);

    String getUserID(User user);

    List<String> getUnenrolledClassesByUser(User user);

    List<String> getClassesCodeByUser(User user);


}
