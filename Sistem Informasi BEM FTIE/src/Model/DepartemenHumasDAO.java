/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.ConnectionDB;
import Model.DepartemenHumas;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Otniel
 */
public class DepartemenHumasDAO {
    ConnectionDB conn;
     final String update = "UPDATE departemen_humas SET jabatan=?WHERE nim=? ;";
    public DepartemenHumasDAO() {
        conn = new ConnectionDB();
    }
    
    public String insertHumas( String NIM, String jabatan) {
        String insert = null;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            CallableStatement cs = bemftie.prepareCall("INSERT INTO departemen_humas ( NIM, jabatan) VALUES(?,?);");
            
            cs.setString(1, NIM);
            cs.setString(2, jabatan);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas > 0) {
                insert = "Insert Sukses";
            }
        } catch (Exception ex) {

        }
        return insert;
    }
    
    public int updateHumas(String nim, String jabatan) {
        int rowUpdated = 0;
        //PreparedStatement statement = null;

        try {
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement(update);
            ps.setString(1, nim);
            ps.setString(2, jabatan);
            
            rowUpdated = ps.executeUpdate();

        } catch (SQLException ex) {

        }
        return rowUpdated;
    }
    
    public String deleteHumas(String id_humas) {
        String delete = null;
        try {
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement("Delete From departemen_humas where id_humas = ?");
            ps.setString(1, id_humas);
            int rowDeleted = ps.executeUpdate();

            if (rowDeleted > 0) {
                delete = "Delete berhasil";
            }
        }
        catch (Exception e){
            
        }
        return delete;
    }
    
    public ArrayList<DepartemenHumas> listDepartemenHumas() {
        ArrayList listEventFtie = new ArrayList();
        DepartemenHumas humas;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            PreparedStatement ps = bemftie.prepareStatement("select * from departemen_humas");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                humas = new DepartemenHumas();
                humas.setId(rs.getInt(1));
                humas.setNIM(rs.getString(2));
                humas.setJabatan(rs.getString(3));
                
                listEventFtie.add(humas);
            }

        } catch (SQLException ex) {

        }
        return listEventFtie;
    }
}
