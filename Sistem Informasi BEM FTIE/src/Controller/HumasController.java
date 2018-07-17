/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Driver.DivisiHumasDriver;
import Model.DepartemenHumasDAO;
import View.frmHumas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Otniel
 */
public class HumasController implements ActionListener {

    frmHumas viewHumas = new frmHumas();
    DepartemenHumasDAO modelHumas = new DepartemenHumasDAO();

    public HumasController(frmHumas viewHumas, DepartemenHumasDAO modelHumas) {
        this.modelHumas = modelHumas;
        this.viewHumas = viewHumas;
        viewHumas.btnSave.addActionListener(this);
        viewHumas.btnUpdate.addActionListener(this);
        viewHumas.btnList.addActionListener(this);
        viewHumas.btnDelete.addActionListener(this);
        viewHumas.btnBack.addActionListener(this);
    }

    public void InisialisasiEvent() {

    }

    public void back() {
        this.viewHumas.dispose();
        DivisiHumasDriver humas = new DivisiHumasDriver();
        humas.start();
    }

    public void ListTable(JTable tblHumas) {
        DefaultTableModel modelTbl = new DefaultTableModel();
        tblHumas.setModel(modelTbl);

        modelTbl.addColumn("ID");
        modelTbl.addColumn("NIM");
        modelTbl.addColumn("Jabatan");

        Object[] column = new Object[5];
        int numUpdate = modelHumas.listDepartemenHumas().size();

        for (int i = 0; i < numUpdate; i++) {
            column[0] = modelHumas.listDepartemenHumas().get(i).getId();
            column[1] = modelHumas.listDepartemenHumas().get(i).getNIM();
            column[2] = modelHumas.listDepartemenHumas().get(i).getJabatan();

            modelTbl.addRow(column);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewHumas.btnSave) {

            String NIM = viewHumas.txtNim.getText();
            String jabatan = viewHumas.txtJabatan.getText();

            String insert = modelHumas.insertHumas(NIM, jabatan);

            if (insert != null) {
                JOptionPane.showMessageDialog(null, insert);
            } else {
                JOptionPane.showMessageDialog(null, "Menyimpan Gagal");
            }
        }
        if (e.getSource() == viewHumas.btnUpdate) {

            String NIM = viewHumas.txtNim.getText();
            String jabatan = viewHumas.txtJabatan.getText();

            int update = modelHumas.updateHumas(NIM, jabatan);

            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Event berhasil di Update");
            } else {
                JOptionPane.showMessageDialog(null, "Update event gagal");
            }
        }
        if(e.getSource()==viewHumas.btnBack){
            this.back();
        }
        if (e.getSource() == viewHumas.btnDelete) {
            int rowSelect = viewHumas.tblHumas.getSelectedRow();
            int numFS = viewHumas.tblHumas.getSelectedRowCount();
            ArrayList<String> listNoPeng = new ArrayList();
            String id_humas = "";
            if (rowSelect > 0) {
                for (int i = 0; i < numFS; i++) {
                    id_humas = String.valueOf(viewHumas.tblHumas.getValueAt(i + rowSelect, 0));
                    listNoPeng.add(id_humas);
                }

                for (int i = 0; i < numFS; i++) {
                    int deleteRow = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus " + id_humas + "dari Departemen ?");
                    if (deleteRow == 0) {
                        modelHumas.deleteHumas(id_humas);
                    }
                }
                ListTable(viewHumas.tblHumas);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menghapus Mahasiswa");
            }
            //String id_pengumuman = viewPengumuman.txtNoPeng.getText();
        }
        if (e.getSource() == viewHumas.btnList) {
            ListTable(viewHumas.tblHumas);
        }
        if (e.getSource() == viewHumas.btnBack) {
            this.back();
        }
    }

}
