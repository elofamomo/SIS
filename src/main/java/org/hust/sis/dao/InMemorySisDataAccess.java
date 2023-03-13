package org.hust.sis.dao;

import org.hust.sis.Class;
import org.hust.sis.Subject;
import org.hust.sis.User;

import java.util.ArrayList;
import java.util.List;

public class InMemorySisDataAccess implements SisDataAccess {
    private List<User> users = new ArrayList<>();
    private List<Class> classes = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void addClass(Class clazz) {
        this.classes.add(clazz);
    }

    @Override
    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
