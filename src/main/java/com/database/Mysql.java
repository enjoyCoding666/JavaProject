package com.database;



import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class Mysql {
    private Connection conn;
    private Statement smt;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            log.error("Mysql error:", e);
        }
    }

    public Mysql(String url, String user, String pwd) throws Exception {
        conn = DriverManager.getConnection(url, user,pwd);
        smt= conn.createStatement();
    }

    public ResultSet executeQuery(String sql) throws Exception {
        ResultSet rs = null;
        try {
            rs = smt.executeQuery(sql);
        } catch (SQLException e) {
            log.error("executeQuery error:", e);
        }
        return rs;
    }

    /**
     *
     * 调用以下的getPrepareStatement(sql)后，可以直接通过以下代码执行sql语句
     * preparedStatement.setInt(1, 75);
     * preparedStatement.setString(2, "Colombian");
     * preparedStatement.executeUpdate();
     * @param sql   参数形如：UPDATE COFFEES SET SALES = ? WHERE COF_NAME LIKE ?
     * @return
     * @throws Exception
     */
    public PreparedStatement getPrepareStatement(String sql) throws  Exception {
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        return  preparedStatement;
    }

    /**
     * 更新失败，记得rollBack
     * @param sql
     * @throws Exception
     */
    public void executeUpdate(String sql) throws Exception {
        try {
            smt.executeUpdate(sql);
            conn.commit();
        }catch(Exception e) {
            if(conn!=null) {
                conn.rollback();
                log.debug("数据已存在或存在错误，开始回滚。");
            }
        }
    }

    public void close() throws Exception {
        smt.close();
        conn.close();
    }
}
