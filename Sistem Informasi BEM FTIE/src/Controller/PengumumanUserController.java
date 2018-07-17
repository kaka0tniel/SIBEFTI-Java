package Controller;

import java.awt.event.*;
import Model.*;
import View.PengumumanUser;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Driver.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HansTCS
 */
public class PengumumanUserController implements ActionListener, KeyListener {

    String value = null;

    PengumumanUser viewUser = new PengumumanUser();
    PengumumanDAO modelPengumuman = new PengumumanDAO();

    public PengumumanUserController(PengumumanUser viewUser, PengumumanDAO modelPengumuman) {
        this.viewUser = viewUser;
        this.modelPengumuman = modelPengumuman;
        viewUser.btnSelect.addActionListener(this);
        viewUser.btnView.addActionListener(this);
        viewUser.txtNoPeng.addActionListener(this);
        viewUser.txtSearch.addKeyListener(this);
        viewUser.btnBack.addActionListener(this);
        ListTable(viewUser.tblPengumuman);
    }

    public void back() {
        this.viewUser.dispose();
        BerandaBemUserDriver beranda = new BerandaBemUserDriver();
        beranda.start();
    }

    public void ListTable(JTable tblPengumuman) {
        DefaultTableModel modelTbl = new DefaultTableModel();
        tblPengumuman.setModel(modelTbl);

        modelTbl.addColumn("No. Pengumuman");
        modelTbl.addColumn("Judul");
        modelTbl.addColumn("Penulis");
        modelTbl.addColumn("Konten");

        Object[] column = new Object[4];
        int numUpdate = modelPengumuman.listPengumumanFtie().size();

        for (int i = 0; i < numUpdate; i++) {
            column[0] = modelPengumuman.listPengumumanFtie().get(i).getId_pengumuman();
            column[1] = modelPengumuman.listPengumumanFtie().get(i).getJudul();
            column[2] = modelPengumuman.listPengumumanFtie().get(i).getPenulis();
            column[3] = modelPengumuman.listPengumumanFtie().get(i).getKonten();
            modelTbl.addRow(column);
        }
    }

    public String getTextField(String st) {
        this.value = st;
        return value;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == viewUser.btnSelect) {
            int rowUpdate = viewUser.tblPengumuman.getSelectedRow();
            int numFS = viewUser.tblPengumuman.getSelectedRowCount();

            if (rowUpdate >= 0 && numFS == 1) {
                viewUser.txtNoPeng.setText(String.valueOf(viewUser.tblPengumuman.getValueAt(rowUpdate, 0)));
                value = viewUser.txtNoPeng.getText();
                viewUser.txtNoPeng.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "Anda diharuskan memilih salah satu data dari tabel pengumuman");
            }
        }
        if (e.getSource() == viewUser.btnView) {
            PengumumanUserDriver2 page2 = new PengumumanUserDriver2();
            page2.start();
        }
        if (e.getSource() == viewUser.btnBack) {
            this.back();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == viewUser.txtSearch) {
            String judul = viewUser.txtSearch.getText();

            DefaultTableModel modelTbl = new DefaultTableModel();
            viewUser.tblPengumuman.setModel(modelTbl);

            modelTbl.addColumn("No. Pengumuman");
            modelTbl.addColumn("Judul");
            modelTbl.addColumn("Penulis");
            modelTbl.addColumn("Konten");

            Object[] column = new Object[4];
            int numUpdate = modelPengumuman.CariPengumumanFtie(judul).size();

            for (int i = 0; i < numUpdate; i++) {
                column[0] = modelPengumuman.CariPengumumanFtie(judul).get(i).getId_pengumuman();
                column[1] = modelPengumuman.CariPengumumanFtie(judul).get(i).getJudul();
                column[2] = modelPengumuman.CariPengumumanFtie(judul).get(i).getPenulis();
                column[3] = modelPengumuman.CariPengumumanFtie(judul).get(i).getKonten();
                modelTbl.addRow(column);
            }
        }
    }

}
