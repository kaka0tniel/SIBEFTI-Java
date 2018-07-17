/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Driver.DivisiKetertibanDriver;
import Driver.LoginDriver;
import Model.EventDepKetertibanDAO;
import Model.*;
import View.EventDepKetertiban;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juliana Christin Siagian
 */
public class EventDepKetertibanController implements ActionListener {

    EventDepKetertiban viewEventDepKetertiban = new EventDepKetertiban();
    EventDepKetertibanDAO modelEventDepKetertiban = new EventDepKetertibanDAO();

    public EventDepKetertibanController(EventDepKetertiban viewEventDepKetertiban, EventDepKetertibanDAO modelEventDepKetertiban) {
        this.modelEventDepKetertiban = modelEventDepKetertiban;
        this.viewEventDepKetertiban = viewEventDepKetertiban;
        viewEventDepKetertiban.btnSave.addActionListener(this);
        viewEventDepKetertiban.btnUpdt.addActionListener(this);
        viewEventDepKetertiban.btnList.addActionListener(this);
        viewEventDepKetertiban.btnDel.addActionListener(this);
        viewEventDepKetertiban.btnBack.addActionListener(this);
    }

    public void InisialisasiEventDepKetertiban() {

    }

    public void back() {
        this.viewEventDepKetertiban.dispose();
        DivisiKetertibanDriver beranda = new DivisiKetertibanDriver();
        beranda.start();
    }

    public void ListTable(JTable tblEventDepKetertiban) {
        DefaultTableModel modelTbl = new DefaultTableModel();
        tblEventDepKetertiban.setModel(modelTbl);

        modelTbl.addColumn("No. Event");
        modelTbl.addColumn("Nama Event");
        modelTbl.addColumn("Start");
        modelTbl.addColumn("End");
        modelTbl.addColumn("Deskripsi");

        Object[] column = new Object[5];
        int numUpdate = modelEventDepKetertiban.listEventDepKetertibanFtie().size();

        for (int i = 0; i < numUpdate; i++) {
            column[0] = modelEventDepKetertiban.listEventDepKetertibanFtie().get(i).getId_event();
            column[1] = modelEventDepKetertiban.listEventDepKetertibanFtie().get(i).getNama_event();
            column[2] = modelEventDepKetertiban.listEventDepKetertibanFtie().get(i).getStart_event();
            column[3] = modelEventDepKetertiban.listEventDepKetertibanFtie().get(i).getEnd_event();
            column[4] = modelEventDepKetertiban.listEventDepKetertibanFtie().get(i).getDeskripsi();
            modelTbl.addRow(column);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewEventDepKetertiban.btnSave) {
            String id_event = viewEventDepKetertiban.txtNo_Ev.getText();
            String nama_event = viewEventDepKetertiban.txtNa_Ev.getText();
            String start_event = viewEventDepKetertiban.txtStrt.getText();
            String end_event = viewEventDepKetertiban.txtEnd.getText();
            String deskripsi = viewEventDepKetertiban.txtDsk.getText();

            String insert = modelEventDepKetertiban.insertEventDepKetertiban(id_event, nama_event, start_event, end_event, deskripsi);

            if (insert != null) {
                JOptionPane.showMessageDialog(null, insert);
            } else {
                JOptionPane.showMessageDialog(null, "Menyimpan Gagal");
            }
        }
        if (e.getSource() == viewEventDepKetertiban.btnBack) {
            this.back();
        }
        if (e.getSource() == viewEventDepKetertiban.btnUpdt) {
            String id_event = viewEventDepKetertiban.txtNo_Ev.getText();
            String nama_event = viewEventDepKetertiban.txtNa_Ev.getText();
            String start_event = viewEventDepKetertiban.txtStrt.getText();
            String end_event = viewEventDepKetertiban.txtEnd.getText();
            String deskripsi = viewEventDepKetertiban.txtDsk.getText();

            int update = modelEventDepKetertiban.update(id_event, nama_event, start_event, end_event, deskripsi);

            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Event berhasil di Update");
            } else {
                JOptionPane.showMessageDialog(null, "Update event gagal");
            }
        }
        if (e.getSource() == viewEventDepKetertiban.btnDel) {
            String id_event = viewEventDepKetertiban.txtNo_Ev.getText();

            String delete = modelEventDepKetertiban.delete(id_event);

            if (delete != null) {
                JOptionPane.showMessageDialog(null, delete);
            } else {
                JOptionPane.showMessageDialog(null, "Menghapus gagal");
            }
        }
        if (e.getSource() == viewEventDepKetertiban.btnList) {
            ListTable(viewEventDepKetertiban.tblEventDepKetertiban);
        }

        if (e.getSource() == viewEventDepKetertiban.btnLgout) {
            EventDepKetertiban viewEventDepKetertibanFtie = new EventDepKetertiban();
            LoginDriver m = new LoginDriver();
            m.start();
            viewEventDepKetertibanFtie.dispose();
        }
    }
}
