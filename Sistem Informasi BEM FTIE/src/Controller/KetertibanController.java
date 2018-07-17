/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Driver.*;
import Model.DepartemenKetertibanDAO;
import View.frmKetertiban;
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
public class KetertibanController implements ActionListener{

    frmKetertiban viewKetertiban = new frmKetertiban();
    DepartemenKetertibanDAO modelKetertiban = new DepartemenKetertibanDAO();
    
    public KetertibanController(frmKetertiban viewKetertiban, DepartemenKetertibanDAO modelKetertiban) {
        this.modelKetertiban = modelKetertiban;
        this.viewKetertiban = viewKetertiban;
        viewKetertiban.btnSave.addActionListener(this);
        viewKetertiban.btnUpdate.addActionListener(this);
        viewKetertiban.btnList.addActionListener(this);
        viewKetertiban.btnDelete.addActionListener(this);
        viewKetertiban.btnBack.addActionListener(this);
    }
    
    public void InisialisasiEvent() {

    }
    
    public void back(){
        this.viewKetertiban.dispose();
        DivisiKetertibanDriver beranda = new DivisiKetertibanDriver();
        beranda.start();
    }
    
    public void ListTable(JTable tblKetertiban) {
        DefaultTableModel modelTbl = new DefaultTableModel();
        tblKetertiban.setModel(modelTbl);

        modelTbl.addColumn("ID");
        modelTbl.addColumn("NIM");
        modelTbl.addColumn("Jabatan");
        

        Object[] column = new Object[5];
        int numUpdate = modelKetertiban.listDepartemenKetertiban().size();

        for (int i = 0; i < numUpdate; i++) {
            column[0] = modelKetertiban.listDepartemenKetertiban().get(i).getId();
            column[1] = modelKetertiban.listDepartemenKetertiban().get(i).getNIM();
            column[2] = modelKetertiban.listDepartemenKetertiban().get(i).getJabatan();
            
            modelTbl.addRow(column);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewKetertiban.btnSave) {
            
            
            String NIM = viewKetertiban.txtNim.getText();
            String jabatan = viewKetertiban.txtJabatan.getText();
            
            String insert = modelKetertiban.insertKetertiban( NIM, jabatan);

            if (insert != null) {
                JOptionPane.showMessageDialog(null, insert);
            } else {
                JOptionPane.showMessageDialog(null, "Menyimpan Gagal");
            }
        }
        if (e.getSource() == viewKetertiban.btnUpdate) {
            
            
            String NIM = viewKetertiban.txtNim.getText();
            String jabatan = viewKetertiban.txtJabatan.getText();
            
            int update = modelKetertiban.updateKetertiban(NIM,jabatan);
            
            if(update>0){
                JOptionPane.showMessageDialog(null, "Event berhasil di Update");
            }
            else{
                JOptionPane.showMessageDialog(null, "Update event gagal");
            }
        }
        if (e.getSource() == viewKetertiban.btnDelete) {
            int rowSelect = viewKetertiban.tblKetertiban.getSelectedRow();
            int numFS = viewKetertiban.tblKetertiban.getSelectedRowCount();
            ArrayList<String> listNoPeng = new ArrayList();
            String id_ketertiban = "";
            if (rowSelect > 0) {
                for (int i = 0; i < numFS; i++) {
                    id_ketertiban = String.valueOf(viewKetertiban.tblKetertiban.getValueAt(i + rowSelect, 0));
                    listNoPeng.add(id_ketertiban);
                }

                for (int i = 0; i < numFS; i++) {
                    int deleteRow = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus " + id_ketertiban + "dari Departemen ?");
                    if (deleteRow == 0) {
                        modelKetertiban.deleteKetertiban(id_ketertiban);
                    }
                }
                ListTable(viewKetertiban.tblKetertiban);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menghapus Mahasiswa");
            }
            //String id_pengumuman = viewPengumuman.txtNoPeng.getText();
        }
        if (e.getSource() == viewKetertiban.btnList) {
            ListTable(viewKetertiban.tblKetertiban);
        }
    }
    
}
