package com.database;

import com.bean.LocalUser;
import com.util.PropertyUtil;
import lombok.extern.slf4j.Slf4j;
import java.sql.PreparedStatement;
import java.util.Properties;

@Slf4j
public class MysqlTest {
    private static String url;
    private static String user;
    private static String password;

//    private static Properties prop = new Properties();


    public static void insertToTableUser(LocalUser localUser) throws Exception {
        url = PropertyUtil.getProperty("url");
        user = PropertyUtil.getProperty("user");
        password = PropertyUtil.getProperty("password");

        Mysql mysql=new Mysql(url,user,password);
        String sql="insert into user values (?,?,?,? ); ";
        PreparedStatement preparedStatement= mysql.getPrepareStatement(sql);
        preparedStatement.setInt(1,localUser.getId());
        preparedStatement.setString(2,localUser.getUserName());
        preparedStatement.setString(3,localUser.getPassword());
        preparedStatement.setInt(4,localUser.getAge());
        preparedStatement.executeUpdate();
        mysql.close();
    }

    /**
     * PrepareStatement使用动态表名
     * @param tableName
     * @param localUser
     * @throws Exception
     */
    public static void insertToDynamicTable(String tableName,LocalUser localUser) throws Exception {
        url = PropertyUtil.getProperty("url");
        user = PropertyUtil.getProperty("user");
        password = PropertyUtil.getProperty("password");

        Mysql mysql=new Mysql(url,user,password);
        String sql="insert into "+tableName+" values (?,?,?,? ); ";
        PreparedStatement preparedStatement= mysql.getPrepareStatement(sql);
        preparedStatement.setInt(1,localUser.getId());
        preparedStatement.setString(2,localUser.getUserName());
        preparedStatement.setString(3,localUser.getPassword());
        preparedStatement.setInt(4,localUser.getAge());
        preparedStatement.executeUpdate();
        mysql.close();
    }

    public static void main(String[] args) throws Exception {
        LocalUser localUser=new LocalUser(11,"lin","lin",25);
        insertToDynamicTable("user",localUser);
    }
}
