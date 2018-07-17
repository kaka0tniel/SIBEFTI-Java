/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.frmMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Driver.*;

/**
 *
 * @author Otniel
 */
public class MahasiswaController implements ActionListener {

    frmMahasiswa viewMahasiswa = new frmMahasiswa();
    MahasiswaDAO modelMahasiswa = new MahasiswaDAO();
    ArrayList<MahasiswaFtie> lb;

    public MahasiswaController(frmMahasiswa viewMahasiswa, MahasiswaDAO modelMahasiswa) {
        this.modelMahasiswa = modelMahasiswa;
        this.viewMahasiswa = viewMahasiswa;
        viewMahasiswa.btnSave.addActionListener(this);
        viewMahasiswa.btnUpdate.addActionListener(this);
        viewMahasiswa.btnList.addActionListener(this);
        viewMahasiswa.btnDelete.addActionListener(this);
        viewMahasiswa.btnBack.addActionListener(this);
    }

    public void InisialisasiEvent() {

    }

    public void back() {
        this.viewMahasiswa.dispose();
        BerandaBemDriver beranda = new BerandaBemDriver();
        beranda.start();
    }

    public void isiField(int row) {
        viewMahasiswa.getTxtNim().setText(lb.get(row).getNIM());
        viewMahasiswa.getTxtNama().setText(lb.get(row).getNama());
        viewMahasiswa.getTxtPassword().setText(lb.get(row).getPassword());
        viewMahasiswa.getTxtTempatLahir().setText(lb.get(row).getTempatLahir());
        viewMahasiswa.getTxtDate().setDateFormatString(lb.get(row).getTanggalLahir());
        viewMahasiswa.getTxtRole().setText(lb.get(row).getRole());
    }

    public void ListTable(JTable tblMahasiswa) {
        DefaultTableModel modelTbl = new DefaultTableModel();
        tblMahasiswa.setModel(modelTbl);

        modelTbl.addColumn("NIM");
        modelTbl.addColumn("Nama ");
        modelTbl.addColumn("Password");
        modelTbl.addColumn("Tempat Lahir");
        modelTbl.addColumn("Tanggal Lahir");

        Object[] column = new Object[5];
        int numUpdate = modelMahasiswa.listMahasiswaFtie().size();

        for (int i = 0; i < numUpdate; i++) {
            column[0] = modelMahasiswa.listMahasiswaFtie().get(i).getNIM();
            column[1] = modelMahasiswa.listMahasiswaFtie().get(i).getNama();
            column[2] = modelMahasiswa.listMahasiswaFtie().get(i).getPassword();
            column[3] = modelMahasiswa.listMahasiswaFtie().get(i).getTempatLahir();
            column[4] = modelMahasiswa.listMahasiswaFtie().get(i).getTanggalLahir();

            modelTbl.addRow(column);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewMahasiswa.btnSave) {
            String NIM = viewMahasiswa.txtNim.getText();
            String nama = viewMahasiswa.txtNama.getText();
            String password = viewMahasiswa.txtPassword.getText();
            String tempatLahir = viewMahasiswa.txtTempatLahir.getText();
            SimpleDateFormat formatTanggalLahir = new SimpleDateFormat("yyyy-MM-dd");
            String tanggalLahir = formatTanggalLahir.format(viewMahasiswa.txtDate.getDate());
            String role = viewMahasiswa.txtRole.getText();
            int role1 = Integer.parseInt(role);

            String insert = modelMahasiswa.insertMahasiswa(NIM, nama, password, tempatLahir, tanggalLahir, role1);

            if (insert != null) {
                JOptionPane.showMessageDialog(null, insert);
            } else {
                JOptionPane.showMessageDialog(null, "Menyimpan Gagal");
            }
        }
        if (e.getSource() == viewMahasiswa.btnUpdate) {
            String NIM = viewMahasiswa.txtNim.getText();
            String nama = viewMahasiswa.txtNama.getText();
            String password = viewMahasiswa.txtPassword.getText();
            String tempatLahir = viewMahasiswa.txtTempatLahir.getText();
            SimpleDateFormat formatTanggalLahir = new SimpleDateFormat("yyyy-MM-dd");
            String tanggalLahir = formatTanggalLahir.format(viewMahasiswa.txtDate.getDate());
            String role = viewMahasiswa.txtRole.getText();
            int role1 = Integer.parseInt(role);

            int update = modelMahasiswa.updateMahasiswa(NIM, nama, password, tempatLahir, tanggalLahir, role1);

            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Event berhasil di Update");
            } else {
                JOptionPane.showMessageDialog(null, "Update event gagal");
            }
        }
        if (e.getSource() == viewMahasiswa.btnDelete) {
            int rowSelect = viewMahasiswa.tblMahasiswa.getSelectedRow();
            int numFS = viewMahasiswa.tblMahasiswa.getSelectedRowCount();
            ArrayList<String> listNoPeng = new ArrayList();
            String nim = "";
            if (rowSelect > 0) {
                for (int i = 0; i < numFS; i++) {
                    nim = String.valueOf(viewMahasiswa.tblMahasiswa.getValueAt(i + rowSelect, 0));
                    listNoPeng.add(nim);
                }

                for (int i = 0; i < numFS; i++) {
                    int deleteRow = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus " + nim + "dari Mahasiswa Ftie ?");
                    if (deleteRow == 0) {
                        modelMahasiswa.deleteMahasiswa(nim);
                    }
                }
                ListTable(viewMahasiswa.tblMahasiswa);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menghapus Mahasiswa");
            }
            //String id_pengumuman = viewPengumuman.txtNoPeng.getText();
        }
        if (e.getSource() == viewMahasiswa.btnList) {
            ListTable(viewMahasiswa.tblMahasiswa);
        }
        if (e.getSource() == viewMahasiswa.btnBack) {
            this.back();
        }
    }

}
