/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Driver.DivisiSarprasDriver;
import Model.DepartemenSarprasDAO;
import View.frmSarpras;
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
public class SarprasController implements ActionListener{

    frmSarpras viewSarpras = new frmSarpras();
    DepartemenSarprasDAO modelSarpras = new DepartemenSarprasDAO();
    
    public SarprasController(frmSarpras viewSarpras, DepartemenSarprasDAO modelSarpras) {
        this.modelSarpras = modelSarpras;
        this.viewSarpras = viewSarpras;
        viewSarpras.btnSave.addActionListener(this);
        viewSarpras.btnUpdate.addActionListener(this);
        viewSarpras.btnList.addActionListener(this);
        viewSarpras.btnDelete.addActionListener(this);
        viewSarpras.btnBack.addActionListener(this);
    }
    
    public void InisialisasiEvent() {

    }
    
    public void back(){
        this.viewSarpras.dispose();
        DivisiSarprasDriver beranda = new DivisiSarprasDriver();
        beranda.start();
    }
    
    public void ListTable(JTable tblSarpras) {
        DefaultTableModel modelTbl = new DefaultTableModel();
        tblSarpras.setModel(modelTbl);

        modelTbl.addColumn("ID");
        modelTbl.addColumn("NIM");
        modelTbl.addColumn("Jabatan");
        

        Object[] column = new Object[5];
        int numUpdate = modelSarpras.listDepartemenSarpras().size();

        for (int i = 0; i < numUpdate; i++) {
            column[0] = modelSarpras.listDepartemenSarpras().get(i).getId();
            column[1] = modelSarpras.listDepartemenSarpras().get(i).getNIM();
            column[2] = modelSarpras.listDepartemenSarpras().get(i).getJabatan();
            
            modelTbl.addRow(column);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewSarpras.btnSave) {
            
            
            String NIM = viewSarpras.txtNim.getText();
            String jabatan = viewSarpras.txtJabatan.getText();
            
            String insert = modelSarpras.insertSarpras( NIM, jabatan);

            if (insert != null) {
                JOptionPane.showMessageDialog(null, insert);
            } else {
                JOptionPane.showMessageDialog(null, "Menyimpan Gagal");
            }
        }
        if (e.getSource() == viewSarpras.btnUpdate) {
            
            
            String NIM = viewSarpras.txtNim.getText();
            String jabatan = viewSarpras.txtJabatan.getText();
            
            int update = modelSarpras.updateSarpras(NIM,jabatan);
            
            if(update>0){
                JOptionPane.showMessageDialog(null, "Event berhasil di Update");
            }
            else{
                JOptionPane.showMessageDialog(null, "Update event gagal");
            }
        }
        if(e.getSource()==viewSarpras.btnBack){
            this.back();
        }
        if (e.getSource() == viewSarpras.btnDelete) {
            int rowSelect = viewSarpras.tblSarpras.getSelectedRow();
            int numFS = viewSarpras.tblSarpras.getSelectedRowCount();
            ArrayList<String> listNoPeng = new ArrayList();
            String id_sarpras = "";
            if (rowSelect > 0) {
                for (int i = 0; i < numFS; i++) {
                    id_sarpras = String.valueOf(viewSarpras.tblSarpras.getValueAt(i + rowSelect, 0));
                    listNoPeng.add(id_sarpras);
                }

                for (int i = 0; i < numFS; i++) {
                    int deleteRow = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus " + id_sarpras + "dari Departemen ?");
                    if (deleteRow == 0) {
                        modelSarpras.deleteSarpras(id_sarpras);
                    }
                }
                ListTable(viewSarpras.tblSarpras);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menghapus Mahasiswa");
            }
            //String id_pengumuman = viewPengumuman.txtNoPeng.getText();
        }
        if (e.getSource() == viewSarpras.btnList) {
            ListTable(viewSarpras.tblSarpras);
        }
    }
    
}
