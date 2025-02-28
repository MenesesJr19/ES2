package com.es2.objectpool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ReusablePool {
    private static ReusablePool instance;
    private ArrayList<HttpURLConnection> pool;
    private int maxPoolSize;

    private ReusablePool() {
        this.pool = new ArrayList<>();
        this.maxPoolSize = 10;
    }

    public synchronized static ReusablePool getInstance() {
        if (instance == null) {
            instance = new ReusablePool();
        }
        return instance;
    }

    public synchronized HttpURLConnection acquire() throws PoolExhaustedException, IOException {
        if (pool.size() < maxPoolSize) {
            HttpURLConnection httpURLConnection = createNewConnection();
            pool.add(httpURLConnection);
            return httpURLConnection;
        } else {
            throw new PoolExhaustedException();
        }
    }

    private synchronized HttpURLConnection createNewConnection() throws IOException {
        return (HttpURLConnection) new java.net.URL("http://example.com").openConnection();
    }

    public synchronized void release(HttpURLConnection conn) throws ObjectNotFoundException {
        if (!pool.contains(conn)) {
            throw new ObjectNotFoundException();
        }
        try {
            conn.disconnect();
            pool.remove(conn);
        } catch (Exception e) {
            throw new ObjectNotFoundException();
        }
    }

    public synchronized void resetPool() {
        this.pool.clear();
    }

    public synchronized void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }
}
