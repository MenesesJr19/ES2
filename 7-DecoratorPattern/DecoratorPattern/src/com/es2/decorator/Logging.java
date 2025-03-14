package com.es2.decorator;

import java.time.LocalDateTime;

public class Logging extends Decorator {
    public Logging(AuthInterface auth) {
        super(auth);
    }

    public void auth(String username, String password) throws AuthException, java.io.IOException {
        System.out.println(LocalDateTime.now() + ",auth()");
        super.auth(username, password);
    }
}