/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.ConnectionDB;
import Model.DepartemenKetertiban;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Otniel
 */
public class DepartemenKetertibanDAO {
    ConnectionDB conn;
     final String update = "UPDATE departemen_ketertiban SET jabatan=?WHERE nim=? ;";
    public DepartemenKetertibanDAO() {
        conn = new ConnectionDB();
    }
    
    public String insertKetertiban( String NIM, String jabatan) {
        String insert = null;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            CallableStatement cs = bemftie.prepareCall("INSERT INTO departemen_ketertiban ( NIM, jabatan) VALUES(?,?);");
            
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
    
    public int updateKetertiban(String nim, String jabatan) {
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
    
    public String deleteKetertiban(String id_ketertiban) {
        String delete = null;
        try {
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement("Delete From departemen_ketertiban where id_ketertiban = ?");
            ps.setString(1, id_ketertiban);
            int rowDeleted = ps.executeUpdate();

            if (rowDeleted > 0) {
                delete = "Delete berhasil";
            }
        }
        catch (Exception e){
            
        }
        return delete;
    }
    
    public ArrayList<DepartemenKetertiban> listDepartemenKetertiban() {
        ArrayList listEventFtie = new ArrayList();
        DepartemenKetertiban ketertiban;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            PreparedStatement ps = bemftie.prepareStatement("select * from departemen_ketertiban");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ketertiban = new DepartemenKetertiban();
                ketertiban.setId(rs.getInt(1));
                ketertiban.setNIM(rs.getString(2));
                ketertiban.setJabatan(rs.getString(3));
                
                listEventFtie.add(ketertiban);
            }

        } catch (SQLException ex) {

        }
        return listEventFtie;
    }
}
