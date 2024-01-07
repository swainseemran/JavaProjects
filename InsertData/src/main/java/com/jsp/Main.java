package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","mysql@123#$*");
        PreparedStatement ps = con.prepareStatement("insert into user(id,name,mobilenumber,email,password,age) values(?,?,?,?,?,?)");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter id: ");
        int id=sc.nextInt();

        System.out.println("Enter name: ");
        String name=sc.next();

        System.out.println("Enter mobilenumber: ");
        long mobilenumber=sc.nextLong();

        System.out.println("Enter email: ");
        String email= sc.next();

        System.out.println("Enter password: ");
        String password=sc.next();

        System.out.println("Enter age: ");
        int age=sc.nextInt();

        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setLong(3,mobilenumber);
        ps.setString(4,email);
        ps.setString(5,password);
        ps.setInt(6,age);

        ps.execute();
        System.out.println("value inserted successfuly");
    }
}