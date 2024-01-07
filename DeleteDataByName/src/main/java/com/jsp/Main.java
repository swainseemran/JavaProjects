package com.jsp;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "mysql@123#$*");
        PreparedStatement ps1 = con.prepareStatement("select * from user where name=?");
        Scanner sc = new Scanner(System.in);
        System.out.println("enter name");
        String name = sc.next();
        ps1.setString(1, name);
        ResultSet rs = ps1.executeQuery();
        if(rs.next()){
            System.out.println("Yes the data is deleted " + rs.getInt(1));

            PreparedStatement ps=con.prepareStatement("delete from user where name=?");
            ps.setString(1,name);
            ps.execute();
            System.out.println("data deleted successfully");
        }
        else{
            System.out.println("sorry data is not available for this name =  " + name);
        }
    }
}