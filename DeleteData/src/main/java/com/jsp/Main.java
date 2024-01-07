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
        PreparedStatement ps=con.prepareStatement("delete from user where id=?");

        Scanner sc=new Scanner(System.in);
        System.out.println("enter id");
        int id=sc.nextInt();
        ps.setInt(1, id);

        ps.execute();
        System.out.println("value deleted successfully");

    }
}