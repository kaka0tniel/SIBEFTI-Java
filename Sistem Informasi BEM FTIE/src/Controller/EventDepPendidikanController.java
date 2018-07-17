/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Driver.*;
import Model.EventDepPendidikanDAO;
import Model.*;
import View.EventDepPendidikan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juliana Christin Siagian
 */
public class EventDepPendidikanController implements ActionListener {

    EventDepPendidikan viewEventDepPendidikan = new EventDepPendidikan();
    EventDepPendidikanDAO modelEventDepPendidikan = new EventDepPendidikanDAO();

    public EventDepPendidikanController(EventDepPendidikan viewEventDepPendidikan, EventDepPendidikanDAO modelEventDepPendidikan) {
        this.modelEventDepPendidikan = modelEventDepPendidikan;
        this.viewEventDepPendidikan = viewEventDepPendidikan;
        viewEventDepPendidikan.btnSave.addActionListener(this);
        viewEventDepPendidikan.btnUpdt.addActionListener(this);
        viewEventDepPendidikan.btnList.addActionListener(this);
        viewEventDepPendidikan.btnDel.addActionListener(this);
        viewEventDepPendidikan.btnBack.addActionListener(this);
    }

    public void InisialisasiEventDepPendidikan() {

    }

    public void back() {
        this.viewEventDepPendidikan.dispose();
        DivisiPendidikanDriver beranda = new DivisiPendidikanDriver();
        beranda.start();
    }

    public void ListTable(JTable tblEventDepPendidikan) {
        DefaultTableModel modelTbl = new DefaultTableModel();
        tblEventDepPendidikan.setModel(modelTbl);

        modelTbl.addColumn("No. Event");
        modelTbl.addColumn("Nama Event");
        modelTbl.addColumn("Start");
        modelTbl.addColumn("End");
        modelTbl.addColumn("Deskripsi");

        Object[] column = new Object[5];
        int numUpdate = modelEventDepPendidikan.listEventDepPendidikanFtie().size();

        for (int i = 0; i < numUpdate; i++) {
            column[0] = modelEventDepPendidikan.listEventDepPendidikanFtie().get(i).getId_event();
            column[1] = modelEventDepPendidikan.listEventDepPendidikanFtie().get(i).getNama_event();
            column[2] = modelEventDepPendidikan.listEventDepPendidikanFtie().get(i).getStart_event();
            column[3] = modelEventDepPendidikan.listEventDepPendidikanFtie().get(i).getEnd_event();
            column[4] = modelEventDepPendidikan.listEventDepPendidikanFtie().get(i).getDeskripsi();
            modelTbl.addRow(column);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewEventDepPendidikan.btnSave) {
            String id_event = viewEventDepPendidikan.txtNo_Ev.getText();
            String nama_event = viewEventDepPendidikan.txtNa_Ev.getText();
            String start_event = viewEventDepPendidikan.txtStrt.getText();
            String end_event = viewEventDepPendidikan.txtEnd.getText();
            String deskripsi = viewEventDepPendidikan.txtDsk.getText();

            String insert = modelEventDepPendidikan.insertEventDepPendidikan(id_event, nama_event, start_event, end_event, deskripsi);

            if (insert != null) {
                JOptionPane.showMessageDialog(null, insert);
            } else {
                JOptionPane.showMessageDialog(null, "Menyimpan Gagal");
            }
        }
        if (e.getSource() == viewEventDepPendidikan.btnUpdt) {
            String id_event = viewEventDepPendidikan.txtNo_Ev.getText();
            String nama_event = viewEventDepPendidikan.txtNa_Ev.getText();
            String start_event = viewEventDepPendidikan.txtStrt.getText();
            String end_event = viewEventDepPendidikan.txtEnd.getText();
            String deskripsi = viewEventDepPendidikan.txtDsk.getText();

            int update = modelEventDepPendidikan.update(id_event, nama_event, start_event, end_event, deskripsi);

            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Event berhasil di Update");
            } else {
                JOptionPane.showMessageDialog(null, "Update event gagal");
            }
        }
        if (e.getSource() == viewEventDepPendidikan.btnDel) {
            String id_event = viewEventDepPendidikan.txtNo_Ev.getText();

            String delete = modelEventDepPendidikan.delete(id_event);

            if (delete != null) {
                JOptionPane.showMessageDialog(null, delete);
            } else {
                JOptionPane.showMessageDialog(null, "Menghapus gagal");
            }
        }
        if (e.getSource() == viewEventDepPendidikan.btnList) {
            ListTable(viewEventDepPendidikan.tblEventDepPendidikan);
        }

        if (e.getSource() == viewEventDepPendidikan.btnLgout) {
            EventDepPendidikan viewEventDepPendidikanFtie = new EventDepPendidikan();
            LoginDriver m = new LoginDriver();
            m.start();
            viewEventDepPendidikanFtie.dispose();
        }
        if (e.getSource() == viewEventDepPendidikan.btnBack) {
            this.back();
        }
    }
}
