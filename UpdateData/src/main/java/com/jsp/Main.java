package com.jsp;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","mysql@123#$*");
        PreparedStatement ps=con.prepareStatement("update user set name=? where id=?");

        Scanner sc=new Scanner(System.in);
        System.out.println("enter new name");
        String name=sc.next();

        System.out.println("enter new id");
        int id=sc.nextInt();

        ps.setString(1,name);
        ps.setInt(2,id);

        ps.execute();
        System.out.println("values updated");
    }
}