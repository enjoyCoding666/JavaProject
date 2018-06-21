package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 通过ThreadLocal解决数据库连接。不同的线程中都有各自的connection副本变量。
 * 这样就保证了一个线程对应一个数据库连接，保证了事务。
 * 因为事务是依赖一个连接来控制的，如commit,rollback,都是数据库连接的方法。
 */
public class ConnectionManager {

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
        @Override
        protected Connection initialValue() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/worker", "root",
                        "root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
    };

    public static Connection getConnection() {
        return connectionHolder.get();
    }

    public static void setConnection(Connection conn) {
        connectionHolder.set(conn);
    }
}