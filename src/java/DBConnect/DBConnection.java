/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnect;

import java.sql.*;

/**
 *
 * @author LENOVO
 */
public class DBConnection {

    /**
     *
     */
    public Connection con;

    /**
     *
     */
    public Statement stmt;

    /**
     *
     */
    public PreparedStatement pstmt;

    /**
     *
     */
    public ResultSet rst;
   
    /**
     *
     * @throws SQLException
     */
    public DBConnection() throws SQLException
    {
        try
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/digital_pocket";
			con=DriverManager.getConnection(url, "root", "");
//                        mammaharshit
        }
        catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }  
}
