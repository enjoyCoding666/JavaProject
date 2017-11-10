package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by lenovo on 2017/7/6.
 */
public class CrudTest {
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
    public static final String URL="jdbc:mysql://localhost:3306/worker";
    public static final String USER="root";
    public static final String PASSWORD="root";

    static {
        try{
            Class.forName(DBDRIVER) ;
            System.out.println("mysql驱动成功加载.");
        }catch(ClassNotFoundException e){
            System.out.println("mysql驱动加载失败");
            e.printStackTrace() ;
        }
    }

    public static void main(String[] args) throws  Exception{
              query();
            insert();
//              update();
//              delete();
              System.out.println("修改后的数据查询如下:");
              query();
    }

    public static void query() throws Exception{
        Connection conn;  //数据库连接
        Statement stmt;   //数据库操作
        String sql="select id,name,age from develops ";
        conn= DriverManager.getConnection(URL,USER,PASSWORD); //连接数据库
        stmt=conn.createStatement();   //实例化Statement对象
        ResultSet rs=stmt.executeQuery(sql);      //执行数据库查询操作
        while(rs.next()){        //指针移动下一行
            String name=rs.getString(2);
            int id=rs.getInt(1);             //获取数据
            int age=rs.getInt(3);
            System.out.println("id:"+id+" name:"+name+" age:"+age);
        }
        rs.close();                     //关闭结果集
        stmt.close();                //操作关闭
        conn.close();                 //数据库关闭
    }

    public static void insert() throws Exception{
        Connection conn=DriverManager.getConnection(URL,USER,PASSWORD);
        conn.setAutoCommit(false);
        Statement stmt=conn.createStatement();
        String sql="insert into develops values ('zeng',1,28)";
        System.out.println(sql);
        stmt.executeUpdate(sql);     //执行更新操作
        conn.commit();               //提交事务
        stmt.close();
        conn.close();
    }

    public static void update() throws Exception{
        Connection conn=DriverManager.getConnection(URL,USER,PASSWORD);
        conn.setAutoCommit(false);
        Statement stmt=conn.createStatement();
        String sql="update develops set id=100 where id=1";
        System.out.println(sql);
        stmt.executeUpdate(sql);     //执行更新操作
        stmt.close();
        conn.close();
    }

    public static void delete() throws Exception{
        Connection conn=DriverManager.getConnection(URL,USER,PASSWORD);
        conn.setAutoCommit(false);
        Statement stmt=conn.createStatement();
        String sql="delete  from develops where id=100 ";
        System.out.println(sql);
        stmt.executeUpdate(sql);     //执行更新操作
        stmt.close();
        conn.close();
    }
}
