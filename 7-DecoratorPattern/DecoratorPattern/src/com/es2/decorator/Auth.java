package com.es2.decorator;

public class Auth extends java.lang.Object implements AuthInterface {
    public Auth() {}

    public void auth(String username, String password) throws AuthException {
        if (!"admin".equals(username) || !"admin".equals(password)) {
            throw new AuthException();
        }
    }
}