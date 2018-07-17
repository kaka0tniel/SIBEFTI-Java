/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.ConnectionDB;
import Model.DepartemenSarpras;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Otniel
 */
public class DepartemenSarprasDAO {
    ConnectionDB conn;
     final String update = "UPDATE departemen_sarpras SET jabatan=?WHERE nim=? ;";
    public DepartemenSarprasDAO() {
        conn = new ConnectionDB();
    }
    
    public String insertSarpras( String NIM, String jabatan) {
        String insert = null;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            CallableStatement cs = bemftie.prepareCall("INSERT INTO departemen_sarpras ( nim, jabatan) VALUES(?,?);");
            
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
    
    public int updateSarpras(String nim, String jabatan) {
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
    
    public String deleteSarpras(String id_sarpras) {
        String delete = null;
        try {
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement("Delete From departemen_sarpras where id_sarpras = ?");
            ps.setString(1, id_sarpras);
            int rowDeleted = ps.executeUpdate();

            if (rowDeleted > 0) {
                delete = "Delete berhasil";
            }
        }
        catch (Exception e){
            
        }
        return delete;
    }
    
    public ArrayList<DepartemenSarpras> listDepartemenSarpras() {
        ArrayList listEventFtie = new ArrayList();
        DepartemenSarpras sarpras;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            PreparedStatement ps = bemftie.prepareStatement("select * from departemen_sarpras");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sarpras = new DepartemenSarpras();
                sarpras.setId(rs.getInt(1));
                sarpras.setNIM(rs.getString(2));
                sarpras.setJabatan(rs.getString(3));
                
                listEventFtie.add(sarpras);
            }

        } catch (SQLException ex) {

        }
        return listEventFtie;
    }
}
