/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Driver.*;
import Model.EventDepHumasDAO;
import Model.*;
import View.EventDepHumas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juliana Christin Siagian
 */
public class EventDepHumasController implements ActionListener {

    EventDepHumas viewEventDepHumas = new EventDepHumas();
    EventDepHumasDAO modelEventDepHumas = new EventDepHumasDAO();

    public EventDepHumasController(EventDepHumas viewEventDepHumas, EventDepHumasDAO modelEventDepHumas) {
        this.modelEventDepHumas = modelEventDepHumas;
        this.viewEventDepHumas = viewEventDepHumas;
        viewEventDepHumas.btnSave.addActionListener(this);
        viewEventDepHumas.btnUpdt.addActionListener(this);
        viewEventDepHumas.btnList.addActionListener(this);
        viewEventDepHumas.btnDel.addActionListener(this);
        viewEventDepHumas.btnBack.addActionListener(this);
    }

    public void InisialisasiEventDepHumas() {

    }

    
    public void ListTable(JTable tblEventDepHumas) {
        DefaultTableModel modelTbl = new DefaultTableModel();
        tblEventDepHumas.setModel(modelTbl);

        modelTbl.addColumn("No. Event");
        modelTbl.addColumn("Nama Event");
        modelTbl.addColumn("Start");
        modelTbl.addColumn("End");
        modelTbl.addColumn("Deskripsi");

        Object[] column = new Object[5];
        int numUpdate = modelEventDepHumas.listEventDepHumasFtie().size();

        for (int i = 0; i < numUpdate; i++) {
            column[0] = modelEventDepHumas.listEventDepHumasFtie().get(i).getId_event();
            column[1] = modelEventDepHumas.listEventDepHumasFtie().get(i).getNama_event();
            column[2] = modelEventDepHumas.listEventDepHumasFtie().get(i).getStart_event();
            column[3] = modelEventDepHumas.listEventDepHumasFtie().get(i).getEnd_event();
            column[4] = modelEventDepHumas.listEventDepHumasFtie().get(i).getDeskripsi();
            modelTbl.addRow(column);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewEventDepHumas.btnSave) {
            String id_event = viewEventDepHumas.txtNo_Ev.getText();
            String nama_event = viewEventDepHumas.txtNa_Ev.getText();
            String start_event = viewEventDepHumas.txtStrt.getText();
            String end_event = viewEventDepHumas.txtEnd.getText();
            String deskripsi = viewEventDepHumas.txtDsk.getText();

            String insert = modelEventDepHumas.insertEventDepHumas(id_event, nama_event, start_event, end_event, deskripsi);

            if (insert != null) {
                JOptionPane.showMessageDialog(null, insert);
            } else {
                JOptionPane.showMessageDialog(null, "Menyimpan Gagal");
            }
        }
        if (e.getSource() == viewEventDepHumas.btnUpdt) {
            String id_event = viewEventDepHumas.txtNo_Ev.getText();
            String nama_event = viewEventDepHumas.txtNa_Ev.getText();
            String start_event = viewEventDepHumas.txtStrt.getText();
            String end_event = viewEventDepHumas.txtEnd.getText();
            String deskripsi = viewEventDepHumas.txtDsk.getText();

            int update = modelEventDepHumas.update(id_event, nama_event, start_event, end_event, deskripsi);

            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Event berhasil di Update");
            } else {
                JOptionPane.showMessageDialog(null, "Update event gagal");
            }
        }
        if (e.getSource() == viewEventDepHumas.btnDel) {
            String id_event = viewEventDepHumas.txtNo_Ev.getText();

            String delete = modelEventDepHumas.delete(id_event);

            if (delete != null) {
                JOptionPane.showMessageDialog(null, delete);
            } else {
                JOptionPane.showMessageDialog(null, "Menghapus gagal");
            }
        }
        if (e.getSource() == viewEventDepHumas.btnList) {
            ListTable(viewEventDepHumas.tblEventDepHumas);
        }

        if (e.getSource() == viewEventDepHumas.btnLgout) {
            LoginDriver m = new LoginDriver();
            m.start();
            viewEventDepHumas.dispose();
        }
        if(e.getSource()==viewEventDepHumas.btnBack){
            DivisiHumasDriver beranda = new DivisiHumasDriver();
            beranda.start();
            viewEventDepHumas.dispose();
        }
    }
}
