package net.lyh.web.dao;

import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_en;

import java.awt.*;
import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws Exception {
//        //加载驱动 sql注入攻击
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        //建立数据库连接
//        String name="root";
//        String pwd="123456";
//        //协议：子协议：//ip:端口/数据库名称?参数=值&参数2=值2
//        String url="jdbc:mysql://127.0.0.1:3306/xdclass?useUnicode=true&characterEncoding=utf-8&useSSL=false";
//        Connection con = DriverManager.getConnection(url, name, pwd);
//        //创建执行SQL的语句statement
//        Statement st = con.createStatement();
//        ResultSet resultSet = st.executeQuery("select * from user");
//        while (resultSet.next()){
//            int id = resultSet.getInt(1);
//            int phone = resultSet.getInt(2);
//            String pwd1 = resultSet.getString("pwd");
//            int sex = resultSet.getInt("sex");
//            System.out.println(id+","+phone+","+pwd1+","+sex);
//        }
//        //处理结果
//        st.close();
//        con.close();
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //建立数据库连接
        String name="root";
        String pwd="123456";
        //协议：子协议：//ip:端口/数据库名称?参数=值&参数2=值2
        String url="jdbc:mysql://127.0.0.1:3306/xdclass?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection con = DriverManager.getConnection(url, name, pwd);
        //创建执行SQL的语句statement
        String name1="jack";
        String pwd2="666";
        PreparedStatement st = con.prepareStatement("select * from user where username=? and pwd =?");
        st.setString(1,name1);
        st.setString(2,pwd2);
        ResultSet resultSet = st.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            int phone = resultSet.getInt(2);
            String pwd1 = resultSet.getString("pwd");
            int sex = resultSet.getInt("sex");
            System.out.println(id+","+phone+","+pwd1+","+sex);
        }
        testAdd();
        //处理结果
        st.close();
        con.close();
    }
    public static void testAdd() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //建立数据库连接
        String name="root";
        String pwd="123456";
        //协议：子协议：//ip:端口/数据库名称?参数=值&参数2=值2
        String url="jdbc:mysql://127.0.0.1:3306/xdclass?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection con = DriverManager.getConnection(url, name, pwd);
        PreparedStatement preparedStatement = con.prepareStatement("insert into user(pwd,sex,img,create_time,username,wechat) values(?,?,?,?,?,?)");
        preparedStatement.setString(1,"lyhlyh123");
        preparedStatement.setInt(2,1);
        preparedStatement.setString(3,"wwwww");
        preparedStatement.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
        preparedStatement.setString(5,"刘小恒");
        preparedStatement.setString(6,"lyh123");
        preparedStatement.execute();

    }
    void trancTest() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //建立数据库连接
        String name="root";
        String pwd="123456";
        //协议：子协议：//ip:端口/数据库名称?参数=值&参数2=值2
        String url="jdbc:mysql://127.0.0.1:3306/xdclass?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection con = DriverManager.getConnection(url, name, pwd);
        con.setAutoCommit(false);
        try(PreparedStatement ps1 = con.prepareStatement("insert into user(username,wechat) values(?,?)");
            PreparedStatement ps2 = con.prepareStatement("insert into user(username,wechat) values(?,?)");){
            ps1.setString(1,"刘大恒");
            ps1.setString(2,"lyh123");
            ps2.setString(1,"薛小丹");
            ps2.setString(2,"xd123");
            ps1.execute();
            ps2.execute();
        }catch (Exception e){
            con.rollback();
            e.printStackTrace();
        }finally {
            con.commit();
        }
    }
}
