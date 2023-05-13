/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author patte
 */
import java.sql.*;
public class Connector {
    public static Connection mycon(){
        String url = "jdbc:mysql://localhost/projectoopdb";
        String username="root";
        String password="OOUdoe85";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            return con;
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
            return null;
        }
    }
}
