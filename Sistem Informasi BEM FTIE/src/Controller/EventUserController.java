/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EventDAO;
import Model.*;
import Driver.*;
import View.EventUser;
import View.EventUser2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juliana Christin Siagian
 */
public class EventUserController implements ActionListener {

    EventUser viewEvent = new EventUser();
    EventDAO modelEvent = new EventDAO();

    public EventUserController(EventUser viewEvent, EventDAO modelEvent) {
        this.modelEvent = modelEvent;
        this.viewEvent = viewEvent;
        viewEvent.btnPilih.addActionListener(this);
        viewEvent.btnView.addActionListener(this);
        ListTable(viewEvent.tblEvent);
        viewEvent.btnBack.addActionListener(this);
    }

    public void InisialisasiEvent() {

    }

    public void back() {
        this.viewEvent.dispose();
        BerandaBemUserDriver beranda = new BerandaBemUserDriver();
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
        if(e.getSource()==viewEvent.btnPilih){
            int rowUpdate = viewEvent.tblEvent.getSelectedRow();
            int numFS = viewEvent.tblEvent.getSelectedRowCount();

            if (rowUpdate >= 0 && numFS == 1) {
                viewEvent.txtNoEvt.setText(String.valueOf(viewEvent.tblEvent.getValueAt(rowUpdate, 0)));
                String value = viewEvent.txtNoEvt.getText();
                viewEvent.txtNoEvt.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "Anda diharuskan memilih salah satu data dari tabel pengumuman");
            }
        }
        if(e.getSource()==viewEvent.btnView){
            EventUserDriver2 view = new EventUserDriver2();
            view.start();
            this.viewEvent.dispose();
        }
        if (e.getSource() == viewEvent.btnBack) {
            this.back();
        }
    }
}
