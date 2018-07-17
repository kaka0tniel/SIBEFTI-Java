/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EventDAO;
import Model.*;
import Driver.*;
import View.frmEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juliana Christin Siagian
 */
public class EventBemController implements ActionListener {

    frmEvent viewEvent = new frmEvent();
    EventDAO modelEvent = new EventDAO();

    public EventBemController(frmEvent viewEvent, EventDAO modelEvent) {
        this.modelEvent = modelEvent;
        this.viewEvent = viewEvent;
        viewEvent.btnSave.addActionListener(this);
        viewEvent.btnUpdt.addActionListener(this);
        viewEvent.btnList.addActionListener(this);
        viewEvent.btnDel.addActionListener(this);
        viewEvent.btnBack.addActionListener(this);
    }

    public void InisialisasiEvent() {

    }

    public void back() {
        this.viewEvent.dispose();
        BerandaBemDriver beranda = new BerandaBemDriver();
        beranda.start();
    }

    public void ListTable(JTable tblEvent) {
        DefaultTableModel modelTbl = new DefaultTableModel();
        tblEvent.setModel(modelTbl);

        modelTbl.addColumn("No. Event");
        modelTbl.addColumn("Nama Event");
        modelTbl.addColumn("Start");
        modelTbl.addColumn("End");
        modelTbl.addColumn("Deskripsi");

        Object[] column = new Object[5];
        int numUpdate = modelEvent.listEventFtie().size();

        for (int i = 0; i < numUpdate; i++) {
            column[0] = modelEvent.listEventFtie().get(i).getId_event();
            column[1] = modelEvent.listEventFtie().get(i).getNama_event();
            column[2] = modelEvent.listEventFtie().get(i).getStart_event();
            column[3] = modelEvent.listEventFtie().get(i).getEnd_event();
            column[4] = modelEvent.listEventFtie().get(i).getDeskripsi();
            modelTbl.addRow(column);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewEvent.btnSave) {
            String id_event = viewEvent.txtNo_Ev.getText();
            String nama_event = viewEvent.txtNa_Ev.getText();
            String start_event = viewEvent.txtStrt.getText();
            String end_event = viewEvent.txtEnd.getText();
            String deskripsi = viewEvent.txtDsk.getText();

            String insert = modelEvent.insertEvent(id_event, nama_event, start_event, end_event, deskripsi);

            if (insert != null) {
                JOptionPane.showMessageDialog(null, insert);
            } else {
                JOptionPane.showMessageDialog(null, "Menyimpan Gagal");
            }
        }
        if (e.getSource() == viewEvent.btnUpdt) {
            String id_event = viewEvent.txtNo_Ev.getText();
            String nama_event = viewEvent.txtNa_Ev.getText();
            String start_event = viewEvent.txtStrt.getText();
            String end_event = viewEvent.txtEnd.getText();
            String deskripsi = viewEvent.txtDsk.getText();

            int update = modelEvent.update(id_event, nama_event, start_event, end_event, deskripsi);

            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Event berhasil di Update");
            } else {
                JOptionPane.showMessageDialog(null, "Update event gagal");
            }
        }
        if (e.getSource() == viewEvent.btnDel) {
            String id_event = viewEvent.txtNo_Ev.getText();

            String delete = modelEvent.delete(id_event);

            if (delete != null) {
                JOptionPane.showMessageDialog(null, delete);
            } else {
                JOptionPane.showMessageDialog(null, "Menghapus gagal");
            }
        }
        if (e.getSource() == viewEvent.btnList) {
            ListTable(viewEvent.tblEvent);
        }
        if (e.getSource() == viewEvent.btnBack) {
            this.back();
        }
    }
}
