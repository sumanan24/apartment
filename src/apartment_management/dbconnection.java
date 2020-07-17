/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartment_management;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ICTSTUDENT
 */
class dbconnection {
    
      static Connection con;
    static Connection getConnetion()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/apartment","root","");  
               
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return con;
    }

    
}
