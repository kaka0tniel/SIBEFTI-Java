/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.ConnectionDB;
import Model.DepartemenPendidikan;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Otniel
 */
public class DepartemenPendidikanDAO {
    ConnectionDB conn;
     final String update = "UPDATE departemen_pendidikan SET jabatan=?WHERE nim=? ;";
    public DepartemenPendidikanDAO() {
        conn = new ConnectionDB();
    }
    
    public String insertPendidikan( String NIM, String jabatan) {
        String insert = null;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            CallableStatement cs = bemftie.prepareCall("INSERT INTO departemen_pendidikan ( NIM, jabatan) VALUES(?,?);");
            
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
    
    public int updatePendidikan(String nim, String jabatan) {
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
    
    public String deletePendidikan(String id_pendidikan) {
        String delete = null;
        try {
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement("Delete From departemen_pendidikan where id_pendidikan = ?");
            ps.setString(1, id_pendidikan);
            int rowDeleted = ps.executeUpdate();

            if (rowDeleted > 0) {
                delete = "Delete berhasil";
            }
        }
        catch (Exception e){
            
        }
        return delete;
    }
    
    public ArrayList<DepartemenPendidikan> listDepartemenPendidikan() {
        ArrayList listDepartemenPendidikan = new ArrayList();
        DepartemenPendidikan pendidikan;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            PreparedStatement ps = bemftie.prepareStatement("select * from departemen_Pendidikan");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pendidikan = new DepartemenPendidikan();
                pendidikan.setId(rs.getInt(1));
                pendidikan.setNIM(rs.getString(2));
                pendidikan.setJabatan(rs.getString(3));
                
                listDepartemenPendidikan.add(pendidikan);
            }

        } catch (SQLException ex) {

        }
        return listDepartemenPendidikan;
    }
}
