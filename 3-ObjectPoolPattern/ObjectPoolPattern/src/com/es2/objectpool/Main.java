package com.es2.objectpool;

import java.net.HttpURLConnection;

public class Main {
    public static void main(String[] args) {
        try {
            ReusablePool pool = ReusablePool.getInstance();
            pool.setMaxPoolSize(5);

            for (int i = 0; i < 7; i++) {
                try {
                    HttpURLConnection connection = pool.acquire();
                    System.out.println("Connection acquired: " + connection);

                    pool.release(connection);
                    System.out.println("Connection released: " + connection);
                } catch (PoolExhaustedException | ObjectNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            pool.resetPool();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}