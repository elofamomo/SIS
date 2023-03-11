package com.x.sis;

import org.hust.sis.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testUserCreation() {
        User user = new User("admin", "admin");
        assertEquals("admin", user.getUsername());
        assertEquals("admin", user.getPassword());
    }

    @Test
    public void testUserEquals() {
        User u1 = new User("admin", "admin");
        User u2 = new User("admin", "admin");

        assertEquals(u1, u2);
        assertNotEquals(u1, null);
        assertNotEquals(u1, "Abc");
    }
}