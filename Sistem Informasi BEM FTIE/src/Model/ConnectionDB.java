package Model;

/**
 *
 * @author HansTCS
 */
import java.sql.*;
import javax.swing.*;

public class ConnectionDB {
    Connection conn = null;
    public static Connection ConnectDB(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/bemftie","root","");
            //JOptionPane.showMessageDialog(null,"Connected to Database");
            return conn;
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
            return null;
        }
    }
    
    
}
