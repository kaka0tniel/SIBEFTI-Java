/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.ConnectionDB;
import Model.MahasiswaFtie;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Otniel
 */
public class MahasiswaDAO {

    ConnectionDB conn;

    public MahasiswaDAO() {
        conn = new ConnectionDB();
    }

    public String insertMahasiswa(String NIM, String nama, String password, String tempatLahir, String tanggalLahir, int role) {
        String insert = null;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            CallableStatement cs = bemftie.prepareCall("INSERT INTO mahasiswa_ftie (nim, nama, password, tempat_lahir,tanggal_lahir, role_id) VALUES(?,?,?,?,?,?);");
            cs.setString(1, NIM);
            cs.setString(2, nama);
            cs.setString(3, password);
            cs.setString(4, tempatLahir);
            cs.setString(5, tanggalLahir);
            cs.setInt(6, role);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas > 0) {
                insert = "Insert Sukses";
            }
        } catch (Exception ex) {

        }
        return insert;
    }

    public int updateMahasiswa(String NIM, String nama, String password, String tempatLahir, String tanggalLahir, int role) {
        int rowUpdated = 0;
        try {
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement("Update mahasiswa_ftie SET nama=?,password=?,tempat_lahir=?,tanggal_lahir=?,role_id=? WHERE nim=?");
            ps.setString(1, NIM);
            ps.setString(2, nama);
            ps.setString(3, password);
            ps.setString(4, tempatLahir);
            ps.setString(5, tanggalLahir);
            ps.setInt(6, role);

            rowUpdated = ps.executeUpdate();
        } catch (Exception ex) {

        }

        return rowUpdated;
    }

    public String deleteMahasiswa(String nim) {
        String delete = null;
        try {
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement("Delete From mahasiswa_ftie where nim = ?");
            ps.setString(1, nim);
            int rowDeleted = ps.executeUpdate();

            if (rowDeleted > 0) {
                delete = "Delete berhasil";
            }
        }
        catch (Exception e){
            
        }
        return delete;
    }

    public ArrayList<MahasiswaFtie> listMahasiswaFtie() {
        ArrayList listMahasiswaFtie = new ArrayList();
        MahasiswaFtie mahasiswa;
        try {
            Connection bemftie = ConnectionDB.ConnectDB();
            PreparedStatement ps = bemftie.prepareStatement("select * from mahasiswa_ftie");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mahasiswa = new MahasiswaFtie();
                mahasiswa.setNIM(rs.getString(1));
                mahasiswa.setNama(rs.getString(2));
                mahasiswa.setPassword(rs.getString(3));
                mahasiswa.setTempatLahir(rs.getString(4));
                mahasiswa.setTanggalLahir(rs.getString(5));
                mahasiswa.setRole(rs.getString(6));

                listMahasiswaFtie.add(mahasiswa);
            }

        } catch (SQLException ex) {

        }
        return listMahasiswaFtie;
    }
}
