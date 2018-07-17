package Controller;

import Driver.*;
import java.awt.event.*;
import Model.*;
import View.frmPengumuman;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HansTCS
 */
public class PengumumanBemController implements ActionListener, KeyListener {

    frmPengumuman viewPengumuman = new frmPengumuman();
    PengumumanDAO modelPengumuman = new PengumumanDAO();

    public PengumumanBemController(frmPengumuman viewPengumuman, PengumumanDAO modelPengumuman) {
        this.modelPengumuman = modelPengumuman;
        this.viewPengumuman = viewPengumuman;
        viewPengumuman.btnSave.addActionListener(this);
        viewPengumuman.btnUpdt.addActionListener(this);
        viewPengumuman.btnGEdit.addActionListener(this);
        viewPengumuman.btnDel.addActionListener(this);
        viewPengumuman.btnReset.addActionListener(this);
        viewPengumuman.txtSearch.addKeyListener(this);
        viewPengumuman.txtJudul.addKeyListener(this);
        viewPengumuman.txtPenulis.addKeyListener(this);
        viewPengumuman.kembali.addActionListener(this);
        ListTable(viewPengumuman.tblPengumuman);
    }

    public void InisialisasiPengumuman() {

    }

    public void back() {
        this.viewPengumuman.dispose();
        BerandaBemDriver beranda = new BerandaBemDriver();
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

    public void reset() {
        viewPengumuman.txtNoPeng.setText("");
        viewPengumuman.txtNoPeng.setEditable(true);
        viewPengumuman.txtJudul.setText("");
        viewPengumuman.txtPenulis.setText("");
        viewPengumuman.txtKtn.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewPengumuman.btnSave) {
            String id_pengumuman = viewPengumuman.txtNoPeng.getText();
            String judul = viewPengumuman.txtJudul.getText();
            String penulis = viewPengumuman.txtPenulis.getText();
            String konten = viewPengumuman.txtKtn.getText();

            String insert = modelPengumuman.insertPengumuman(id_pengumuman, judul, penulis, konten);

            if (insert != null) {
                JOptionPane.showMessageDialog(null, insert);
                ListTable(viewPengumuman.tblPengumuman);
            } else {
                JOptionPane.showMessageDialog(null, "Menyimpan Gagal");
            }
        }
        if (e.getSource() == viewPengumuman.kembali) {
            this.back();
        }
        if (e.getSource() == viewPengumuman.btnUpdt) {
            int rowUpdate = viewPengumuman.tblPengumuman.getSelectedRow();
            int numFS = viewPengumuman.tblPengumuman.getSelectedRowCount();

            if (rowUpdate >= 0 && numFS == 1) {
                viewPengumuman.txtNoPeng.setText(String.valueOf(viewPengumuman.tblPengumuman.getValueAt(rowUpdate, 0)));
                viewPengumuman.txtNoPeng.setEditable(false);
                /* viewPengumuman.txtJudul.setEnabled(false);
                viewPengumuman.txtPenulis.setEnabled(false);
                viewPengumuman.txtKtn.setEnabled(false);*/

            } else {
                JOptionPane.showMessageDialog(null, "Anda diharuskan memilih salah satu data dari tabel pengumuman");
            }
        }
        if (e.getSource() == viewPengumuman.btnGEdit) {
            String id_pengumuman = viewPengumuman.txtNoPeng.getText();
            String judul = viewPengumuman.txtJudul.getText();
            String penulis = viewPengumuman.txtPenulis.getText();
            String konten = viewPengumuman.txtKtn.getText();

            int update = modelPengumuman.updatePengumuman(id_pengumuman, judul, penulis, konten);

            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Pengumuman telah diupdate");
                ListTable(viewPengumuman.tblPengumuman);
            } else {
                JOptionPane.showMessageDialog(null, "Update Gagal");
            }
            reset();
            /*viewPengumuman.btnSave.setEnabled(true);
            viewPengumuman.btnUpdt.setEnabled(true);
            viewPengumuman.btnDel.setEnabled(true);
            viewPengumuman.btnGEdit.setEnabled(false);*/
        }

        if (e.getSource() == viewPengumuman.btnDel) {
            int rowSelect = viewPengumuman.tblPengumuman.getSelectedRow();
            int numFS = viewPengumuman.tblPengumuman.getSelectedRowCount();
            ArrayList<String> listNoPeng = new ArrayList();
            String id_pengumuman = "";
            String judul = "";
            if (rowSelect > 0) {
                for (int i = 0; i < numFS; i++) {
                    id_pengumuman = String.valueOf(viewPengumuman.tblPengumuman.getValueAt(i + rowSelect, 0));
                    judul = String.valueOf(viewPengumuman.tblPengumuman.getValueAt(i + rowSelect, 1));
                    listNoPeng.add(id_pengumuman);
                }

                for (int i = 0; i < numFS; i++) {
                    int deleteRow = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus pengumuman " + judul + " ?");
                    if (deleteRow == 0) {
                        modelPengumuman.deletePengumuman(id_pengumuman);
                    }
                }
                ListTable(viewPengumuman.tblPengumuman);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menghapus pengumuman");
            }
            //String id_pengumuman = viewPengumuman.txtNoPeng.getText();
        }
        if (e.getSource() == viewPengumuman.btnReset) {
            viewPengumuman.txtNoPeng.setText("");
            viewPengumuman.txtJudul.setText("");
            viewPengumuman.txtPenulis.setText("");
            viewPengumuman.txtKtn.setText("");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == viewPengumuman.txtJudul || e.getSource() == viewPengumuman.txtPenulis) {
            char c = e.getKeyChar();
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != (char) KeyEvent.VK_SPACE)) {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == viewPengumuman.txtSearch) {
            String judul = viewPengumuman.txtSearch.getText();

            DefaultTableModel modelTbl = new DefaultTableModel();
            viewPengumuman.tblPengumuman.setModel(modelTbl);

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
