package com.jdbctest.util;

public class DBUtil {
    public static void close(AutoCloseable conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception _) {}
        }
    }
}
