package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","mysql@123#$*");
        Statement st=con.createStatement();

        st.addBatch("insert into user(id,name,mobilenumber,email,password,age) values(7,'A',123,'A@gmail.com',4560,21)");
        st.addBatch("insert into user(id,name,mobilenumber,email,password,age) values(8,'B',145,'B@gmail.com',8362,23)");
        st.addBatch("insert into user(id,name,mobilenumber,email,password,age) values(9,'C',267,'C@gmail.com',5721,20)");
        st.addBatch("update user set name='C', age=25 where id=9");
        st.addBatch("insert into user(id,name,mobilenumber,email,password,age) values(10,'D',870,'D@gmail.com',7602,19)");
        st.addBatch("insert into user(id,name,mobilenumber,email,password,age) values(11,'E',635,'E@gmail.com',4560,24)");
        st.addBatch("update user set name='G' where id=11");
        st.addBatch("update user set name='P', mobilenumber=456  where id=7");
        st.addBatch("insert into user(id,name,mobilenumber,email,password,age) values(12,'F',880,'F@gmail.com',5402,24)");
        st.addBatch("delete from user where id in(7,9)");

        st.executeBatch();
        System.out.println("batch executed");
    }
}