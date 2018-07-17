package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HansTCS
 */
public class PengumumanDAO {

    ConnectionDB conn;
    final String update = "UPDATE pengumuman_ftie SET judul=?, penulis=?, konten=? WHERE id_pengumuman=? ;";

    public PengumumanDAO() {
        conn = new ConnectionDB();
    }

    public String insertPengumuman(String id_pengumuman, String judul, String penulis, String konten) {
        String insert = null;
        try {
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement cs = connect.prepareStatement("INSERT INTO pengumuman_ftie (id_pengumuman, judul, penulis, konten) VALUES(?,?,?,?);");
            cs.setString(1, id_pengumuman);
            cs.setString(2, judul);
            cs.setString(3, penulis);
            cs.setString(4, konten);

            int rowInserted = cs.executeUpdate();

            if (rowInserted > 0) {
                insert = "Insert Sukses";
            }
        } catch (Exception ex) {
        }
        return insert;
    }

    public int updatePengumuman(String id_pengumuman, String judul, String penulis, String konten) {
        int rowUpdated = 0;
        //PreparedStatement statement = null;

        try {
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement(update);
            ps.setString(1, judul);
            ps.setString(2, penulis);
            ps.setString(3, konten);
            ps.setString(4, id_pengumuman);

            rowUpdated = ps.executeUpdate();

        } catch (SQLException ex) {

        }
        return rowUpdated;
    }

    public String deletePengumuman(String id_pengumuman) {
        String delete = null;

        try {
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement("DELETE FROM pengumuman_ftie where id_pengumuman=? ;");
            ps.setString(1, id_pengumuman);

            int rowDeleted = ps.executeUpdate();

            if (rowDeleted > 0) {
                delete = "Delete Sukses";
            }
        } catch (SQLException ex) {
        }

        return delete;
    }

    public ArrayList<PengumumanFtie> listPengumumanFtie() {
        ArrayList listPengumumanFtie = new ArrayList();
        PengumumanFtie pengumuman;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            PreparedStatement ps = bemftie.prepareStatement("select * from pengumuman_ftie");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pengumuman = new PengumumanFtie();
                pengumuman.setId_pengumuman(rs.getString(1));
                pengumuman.setJudul(rs.getString(2));
                pengumuman.setPenulis(rs.getString(3));
                pengumuman.setKonten(rs.getString(4));

                listPengumumanFtie.add(pengumuman);
            }

        } catch (SQLException ex) {

        }
        return listPengumumanFtie;
    }

    public ArrayList<PengumumanFtie> CariPengumumanFtie(String Judul) {
        ArrayList<PengumumanFtie> listPengumumanFtie = new ArrayList();
        PengumumanFtie pengumuman;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            PreparedStatement ps = bemftie.prepareStatement("SELECT * FROM pengumuman_ftie WHERE judul LIKE ? ;");
            ps.setString(1, "%" + Judul + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pengumuman = new PengumumanFtie();
                pengumuman.setId_pengumuman(rs.getString(1));
                pengumuman.setJudul(rs.getString(2));
                pengumuman.setPenulis(rs.getString(3));
                pengumuman.setKonten(rs.getString(4));

                listPengumumanFtie.add(pengumuman);
            }

        } catch (SQLException ex) {

        }
        return listPengumumanFtie;
    }

    public ResultSet ViewPengumumanFtie(String id_pengumuman) {
        ResultSet rs = null;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            PreparedStatement ps = bemftie.prepareStatement("SELECT * FROM pengumuman_ftie WHERE id_pengumuman=? ;");
            ps.setString(1, id_pengumuman);
            rs = ps.executeQuery();
        } catch (SQLException ex) {

        }
        return rs;
    }

}
