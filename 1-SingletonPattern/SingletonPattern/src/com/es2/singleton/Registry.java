package com.es2.singleton;
public class Registry {
    private static Registry instance;
    private String path;
    private String connectionString;

    private Registry() {
        this.path = "";
        this.connectionString = "";
    }

    public static synchronized Registry getInstance() {
        if (instance == null) {
            instance = new Registry();
        }
        return instance;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
}