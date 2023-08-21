/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileTrack;

import java.sql.*;

public class MyLib {
    public Connection getConnection()
    {
        Connection cn=null;
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           String dbpath= "jdbc:mysql://localhost:3306/filetracker";
           String dbuser="root";
           String dbpass="";
           
           cn=DriverManager.getConnection(dbpath,dbuser,dbpass);
        }
        catch(Exception e)
        {
          System.out.println("Error in getConnection" +e);
        }
        return cn;
    }
}
