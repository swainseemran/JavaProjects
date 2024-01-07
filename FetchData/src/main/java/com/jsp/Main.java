package com.jsp;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","mysql@123#$*");
        PreparedStatement ps=con.prepareStatement("select * from  user where id=?");

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter id: ");
        int id=sc.nextInt();

        ps.setInt(1,id);

        ResultSet rs=ps.executeQuery();

        if (rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getLong(3));
            System.out.println(rs.getString(4));
            System.out.println(rs.getString(5));
            System.out.println(rs.getInt(6));
        }
        else {
            System.out.println("Invalid id");
        }

    }
}