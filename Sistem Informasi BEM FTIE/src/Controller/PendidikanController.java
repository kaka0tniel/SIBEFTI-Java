/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DepartemenPendidikanDAO;
import View.frmPendidikan;
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
public class PendidikanController implements ActionListener{

    frmPendidikan viewPendidikan = new frmPendidikan();
    DepartemenPendidikanDAO modelPendidikan = new DepartemenPendidikanDAO();
    
    public PendidikanController(frmPendidikan viewPendidikan, DepartemenPendidikanDAO modelPendidikan) {
        this.modelPendidikan = modelPendidikan;
        this.viewPendidikan = viewPendidikan;
        viewPendidikan.btnSave.addActionListener(this);
        viewPendidikan.btnUpdate.addActionListener(this);
        viewPendidikan.btnList.addActionListener(this);
        viewPendidikan.btnDelete.addActionListener(this);
    }
    
    public void InisialisasiEvent() {

    }
    
    public void ListTable(JTable tblPendidikan) {
        DefaultTableModel modelTbl = new DefaultTableModel();
        tblPendidikan.setModel(modelTbl);

        modelTbl.addColumn("ID");
        modelTbl.addColumn("NIM");
        modelTbl.addColumn("Jabatan");
        

        Object[] column = new Object[5];
        int numUpdate = modelPendidikan.listDepartemenPendidikan().size();

        for (int i = 0; i < numUpdate; i++) {
            column[0] = modelPendidikan.listDepartemenPendidikan().get(i).getId();
            column[1] = modelPendidikan.listDepartemenPendidikan().get(i).getNIM();
            column[2] = modelPendidikan.listDepartemenPendidikan().get(i).getJabatan();
            
            modelTbl.addRow(column);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewPendidikan.btnSave) {
            
            
            String NIM = viewPendidikan.txtNim.getText();
            String jabatan = viewPendidikan.txtJabatan.getText();
            
            String insert = modelPendidikan.insertPendidikan( NIM, jabatan);

            if (insert != null) {
                JOptionPane.showMessageDialog(null, insert);
            } else {
                JOptionPane.showMessageDialog(null, "Menyimpan Gagal");
            }
        }
        if (e.getSource() == viewPendidikan.btnUpdate) {
            
            
            String NIM = viewPendidikan.txtNim.getText();
            String jabatan = viewPendidikan.txtJabatan.getText();
            
            int update = modelPendidikan.updatePendidikan(NIM,jabatan);
            
            if(update>0){
                JOptionPane.showMessageDialog(null, "Event berhasil di Update");
            }
            else{
                JOptionPane.showMessageDialog(null, "Update event gagal");
            }
        }
        if (e.getSource() == viewPendidikan.btnDelete) {
            int rowSelect = viewPendidikan.tblPendidikan.getSelectedRow();
            int numFS = viewPendidikan.tblPendidikan.getSelectedRowCount();
            ArrayList<String> listNoPeng = new ArrayList();
            String id_pendidikan = "";
            if (rowSelect > 0) {
                for (int i = 0; i < numFS; i++) {
                    id_pendidikan = String.valueOf(viewPendidikan.tblPendidikan.getValueAt(i + rowSelect, 0));
                    listNoPeng.add(id_pendidikan);
                }

                for (int i = 0; i < numFS; i++) {
                    int deleteRow = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus " + id_pendidikan + "dari Departemen ?");
                    if (deleteRow == 0) {
                        modelPendidikan.deletePendidikan(id_pendidikan);
                    }
                }
                ListTable(viewPendidikan.tblPendidikan);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menghapus Mahasiswa");
            }
            //String id_pengumuman = viewPengumuman.txtNoPeng.getText();
        }
        if (e.getSource() == viewPendidikan.btnList) {
            ListTable(viewPendidikan.tblPendidikan);
        }
    }
    
}
