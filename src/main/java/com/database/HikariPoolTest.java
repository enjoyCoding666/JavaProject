package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HikariPoolTest {
    public static void main(String[] args) throws Exception {
        Connection connection= HikariPoolManager.getConnection();
        Statement statement=connection.createStatement();
        String sql="select user_name from user where id=1" ;
        ResultSet resultSet=statement.executeQuery(sql);
        while (resultSet.next()) {
            String userName=   resultSet.getString(1);
            System.out.println(userName);
        }
        HikariPoolManager.freeConnection(connection);
    }
}
