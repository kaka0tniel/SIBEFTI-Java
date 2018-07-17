/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Driver.DivisiSarprasDriver;
import Driver.LoginDriver;
import Model.EventDepSarprasDAO;
import Model.*;
import View.EventDepSarpras;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juliana Christin Siagian
 */
public class EventDepSarprasController implements ActionListener {

    EventDepSarpras viewEventDepSarpras = new EventDepSarpras();
    EventDepSarprasDAO modelEventDepSarpras = new EventDepSarprasDAO();

    public EventDepSarprasController(EventDepSarpras viewEventDepSarpras, EventDepSarprasDAO modelEventDepSarpras) {
        this.modelEventDepSarpras = modelEventDepSarpras;
        this.viewEventDepSarpras = viewEventDepSarpras;
        viewEventDepSarpras.btnSave.addActionListener(this);
        viewEventDepSarpras.btnUpdt.addActionListener(this);
        viewEventDepSarpras.btnList.addActionListener(this);
        viewEventDepSarpras.btnDel.addActionListener(this);
        viewEventDepSarpras.btnBack.addActionListener(this);
    }

    public void InisialisasiEventDepSarpras() {

    }

    public void back() {
        this.viewEventDepSarpras.dispose();
        DivisiSarprasDriver beranda = new DivisiSarprasDriver();
        beranda.start();
    }

    public void ListTable(JTable tblEventDepSarpras) {
        DefaultTableModel modelTbl = new DefaultTableModel();
        tblEventDepSarpras.setModel(modelTbl);

        modelTbl.addColumn("No. Event");
        modelTbl.addColumn("Nama Event");
        modelTbl.addColumn("Start");
        modelTbl.addColumn("End");
        modelTbl.addColumn("Deskripsi");

        Object[] column = new Object[5];
        int numUpdate = modelEventDepSarpras.listEventDepSarprasFtie().size();

        for (int i = 0; i < numUpdate; i++) {
            column[0] = modelEventDepSarpras.listEventDepSarprasFtie().get(i).getId_event();
            column[1] = modelEventDepSarpras.listEventDepSarprasFtie().get(i).getNama_event();
            column[2] = modelEventDepSarpras.listEventDepSarprasFtie().get(i).getStart_event();
            column[3] = modelEventDepSarpras.listEventDepSarprasFtie().get(i).getEnd_event();
            column[4] = modelEventDepSarpras.listEventDepSarprasFtie().get(i).getDeskripsi();
            modelTbl.addRow(column);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewEventDepSarpras.btnSave) {
            String id_event = viewEventDepSarpras.txtNo_Ev.getText();
            String nama_event = viewEventDepSarpras.txtNa_Ev.getText();
            String start_event = viewEventDepSarpras.txtStrt.getText();
            String end_event = viewEventDepSarpras.txtEnd.getText();
            String deskripsi = viewEventDepSarpras.txtDsk.getText();

            String insert = modelEventDepSarpras.insertEventDepSarpras(id_event, nama_event, start_event, end_event, deskripsi);

            if (insert != null) {
                JOptionPane.showMessageDialog(null, insert);
            } else {
                JOptionPane.showMessageDialog(null, "Menyimpan Gagal");
            }
        }
        if(e.getSource()==viewEventDepSarpras.btnBack){
            this.back();
        }
        if (e.getSource() == viewEventDepSarpras.btnUpdt) {
            String id_event = viewEventDepSarpras.txtNo_Ev.getText();
            String nama_event = viewEventDepSarpras.txtNa_Ev.getText();
            String start_event = viewEventDepSarpras.txtStrt.getText();
            String end_event = viewEventDepSarpras.txtEnd.getText();
            String deskripsi = viewEventDepSarpras.txtDsk.getText();

            int update = modelEventDepSarpras.update(id_event, nama_event, start_event, end_event, deskripsi);

            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Event berhasil di Update");
            } else {
                JOptionPane.showMessageDialog(null, "Update event gagal");
            }
        }
        if (e.getSource() == viewEventDepSarpras.btnDel) {
            String id_event = viewEventDepSarpras.txtNo_Ev.getText();

            String delete = modelEventDepSarpras.delete(id_event);

            if (delete != null) {
                JOptionPane.showMessageDialog(null, delete);
            } else {
                JOptionPane.showMessageDialog(null, "Menghapus gagal");
            }
        }
        if (e.getSource() == viewEventDepSarpras.btnList) {
            ListTable(viewEventDepSarpras.tblEventDepSarpras);
        }

        if (e.getSource() == viewEventDepSarpras.btnLgout) {
            EventDepSarpras viewEventDepSarprasFtie = new EventDepSarpras();
            LoginDriver m = new LoginDriver();
            m.start();
            viewEventDepSarprasFtie.dispose();
        }
    }
}
