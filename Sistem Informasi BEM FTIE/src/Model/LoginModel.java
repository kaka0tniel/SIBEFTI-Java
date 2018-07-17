package Model;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author HansTCS
 */
public class LoginModel {

    private int Nim;
    private String password;

    public int getNim() {
        return Nim;
    }

    public void setNim(int Nim) {
        this.Nim = Nim;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ResultSet Logins(int nim, String password) {
        ResultSet rs = null;
        try {
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement("Select * from mahasiswa_ftie where nim=? and password = ?");
            ps.setInt(1, nim);
            ps.setString(2, password);
            rs = ps.executeQuery();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Username atau password masih salah", "Wrong Credential", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
}
