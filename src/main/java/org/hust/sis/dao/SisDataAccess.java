package org.hust.sis.dao;

import org.hust.sis.Class;
import org.hust.sis.Subject;
import org.hust.sis.User;

import java.util.List;

public interface SisDataAccess {
    void addUser(User user);
    void addClass(Class clazz);

    void addSubject(Subject subject);

    List<User> getUsers();
}
