package com.jsp;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        //1. Register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driver registered successfully");
        System.out.println("Seemran");

        //2. Establish the Connection
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","mysql@123#$*");
        System.out.println("connection establish");

        //3. create statement
        Statement st=con.createStatement();
        System.out.println("statement is created successfully");

        //4. Execute statement
        st.execute("create database hospital");
        st.execute("create database school");
        System.out.println("database created successfully");

//        st.execute("create table student(id int,name varchar(20), age int)");
        st.execute("create table user(id int,name varchar(20), mobilenumber long,email varchar(20), password varchar(15), age int)");
        System.out.println("table create successfully");


        //Insert Data
        st.execute("insert into student(id,name,age) values (1,'A',10)");
        st.execute("insert into student(id,name,age) values (2,'B',20)");
        st.execute("insert into student(id,name,age) values (3,'C',30)");

        System.out.println("data inserted successfully");

        //Update Data
        st.execute("update student set name='Seemran' where id=2");
        System.out.println("data updated successfully");

        //Delete Data
        st.execute("delete from student where name in ('B','C') ");
        System.out.println("data deleted successfully");


        //5. Processing the ResultSet or Fetching the Data
        ResultSet rs=st.executeQuery("select * from student where id=2");
        rs.next();

        System.out.println(rs.getInt("id"));//provide column name
        System.out.println(rs.getString("name")); // "
        System.out.println(rs.getInt("age")); //  "

        System.out.println("___________________________________");

        System.out.println(rs.getInt(1));//column index position
        System.out.println(rs.getString(2));// "
        System.out.println(rs.getInt(3));// "

    }
}



//        Class.forName("com.mysql.cj.jdbc.Driver");
//        System.out.println("Driver registered successfully");
//
//        String url = "jdbc:mysql://localhost:3306/mysql";
//        String username = "root";
//        String password = "root";
//        try {
//            Connection con = DriverManager.getConnection(url, username, password);
//            System.out.println("Connection established successfully");
//            con.close();
//        }catch (SQLException e) {
//            System.out.println("Invalid credentials");
//        }

//one way to create object of a class without using new keyword & forName() is a static method
//to class the object of class it is internally store inside jdbc memory