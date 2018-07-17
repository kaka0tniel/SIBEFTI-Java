/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.ConnectionDB;
import Model.EventDepSarprasFtie;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author stu
 */
public class EventDepSarprasDAO {
    ConnectionDB conn;

    public EventDepSarprasDAO() {
        conn = new ConnectionDB();
    }

    public String insertEventDepSarpras(String id_event, String nama_event, String start_event, String end_event, String deskripsi) {
        String insert = null;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            PreparedStatement cs = bemftie.prepareStatement("INSERT INTO event_dep_sarpras_ftie (id_event, nama_event, start_event, end_event, deskripsi) VALUES(?,?,?,?,?);");
            cs.setString(1, id_event);
            cs.setString(2, nama_event);
            cs.setString(3, start_event);
            cs.setString(4, end_event);
            cs.setString(5, deskripsi);
            
            int numFAfectas = cs.executeUpdate();

            if (numFAfectas > 0) {
                insert = "Insert Sukses";
            }
        } catch (Exception ex) {

        }
        return insert;
    }
    public int update(String id_event, String nama_event, String start_event, String end_event, String deskripsi) {
        int rowUpdated = 0;
        try {
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement("UPDATE event_dep_sarpras_ftie SET nama_event=?, start_event=?, end_event=?, deskripsi=? WHERE id_event=? ;");
            ps.setString(1, nama_event);
            ps.setString(2, start_event);
            ps.setString(3, end_event);
            ps.setString(4, deskripsi);
            ps.setString(5, id_event);

            rowUpdated = ps.executeUpdate();
        } catch (Exception ex) {

        }

        return rowUpdated;
    }
    
    public String delete(String id_event){
        String delete=null;
        try{
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement("DELETE FROM event_dep_sarpras_ftie where id_event = ?");
            ps.setString(1, id_event);
            int rowDeleted = ps.executeUpdate();
            
            if(rowDeleted > 0){
                delete = "Delete Berhasil";
            }
        }
        catch(Exception e){
            
        }
        
        return delete;
    }
    
    public ArrayList<EventDepSarprasFtie> listEventDepSarprasFtie() {
        ArrayList listEventDepSarprasFtie = new ArrayList();
        EventDepSarprasFtie event;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            PreparedStatement ps = bemftie.prepareStatement("select * from event_dep_sarpras_ftie");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                event = new EventDepSarprasFtie();
                event.setId_event(rs.getString(1));
                event.setNama_event(rs.getString(2));
                event.setStart_event(rs.getString(3));
                event.setEnd_event(rs.getString(4));
                event.setDeskripsi(rs.getString(5));

                listEventDepSarprasFtie.add(event);
            }

        } catch (SQLException ex) {

        }
        return listEventDepSarprasFtie;
    }
}
