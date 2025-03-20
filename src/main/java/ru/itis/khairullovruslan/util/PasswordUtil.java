package ru.itis.khairullovruslan.util;

import at.favre.lib.crypto.bcrypt.BCrypt;


public class PasswordUtil {

    public static String hashPassword(String plainTextPassword) {
        return BCrypt.withDefaults().hashToString(12, plainTextPassword.toCharArray());
    }
}