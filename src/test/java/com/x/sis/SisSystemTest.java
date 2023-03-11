package com.x.sis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SisSystemTest {

//    @Test
//    public void testAddUser_SuccessIfNotExisted() {
//        SisSystem sisSystem = new SisSystem();
//
//        User user = new User("admin", "admin");
//        boolean status = sisSystem.addUser(user);
//        assertTrue(status);
//    }
//
//    @Test
//    public void testAddUser_FailureIfExisted() {
//        SisSystem sisSystem = new SisSystem();
//
//        User user1 = new User("admin", "admin");
//        sisSystem.addUser(user1);
//
//        User user2 = new User("admin", "admin");
//        boolean status = sisSystem.addUser(user2);
//
//        assertFalse(status);
//    }
//
//    @Test
//    public void testLogin_SuccessIfCorrectUsernameAndPassword() {
//        SisSystem sisSystem = new SisSystem();
//        User u1 = new User("admin", "admin");
//        sisSystem.addUser(u1);
//        User u2 = new User("johndoe", "johndoe");
//        sisSystem.addUser(u2);
//
//        boolean status = sisSystem.login("admin", "admin");
//        assertTrue(status);
//    }
//
//    @Test
//    public void testLogin_FailureIfIncorrectUsernameOrPassword() {
//        SisSystem sisSystem = new SisSystem();
//        User u1 = new User("admin", "admin");
//        sisSystem.addUser(u1);
//        User u2 = new User("johndoe", "johndoe");
//        sisSystem.addUser(u2);
//
//        boolean status = sisSystem.login("admin0", "admin");
//        assertFalse(status);
//
//        status = sisSystem.login("admin", "admin222");
//        assertFalse(status);
//
//        status = sisSystem.login("adminhhh", "admin222");
//        assertFalse(status);
//    }
}