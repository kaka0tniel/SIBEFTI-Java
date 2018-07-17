package Controller;

import java.awt.event.*;
import Model.AspirasiModel;
import View.AspirasiMahasiswa;
import Driver.*;
import javax.swing.JOptionPane;

/**
 *
 * @author HansTCS
 */
public class AspirasiController implements ActionListener {

    AspirasiMahasiswa view = new AspirasiMahasiswa();
    AspirasiModel model = new AspirasiModel();

    public AspirasiController(AspirasiMahasiswa view, AspirasiModel model) {
        this.model = model;
        this.view = view;
        view.btnSave.addActionListener(this);
        view.btnReset.addActionListener(this);
        view.btnBack.addActionListener(this);
    }

    public void back() {
        this.view.dispose();
        BerandaBemUserDriver beranda = new BerandaBemUserDriver();
        beranda.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnSave) {
            String nim = view.txtNim.getText();
            int Nim = Integer.parseInt(nim);
            String aspirasi = view.txtAspirasi.getText();

            String insert = model.insert(Nim, aspirasi);

            if (insert != null) {
                JOptionPane.showMessageDialog(null, insert);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menyimpan aspirasi");
            }
        }
        if (e.getSource() == view.btnReset) {
            view.txtNim.setText("");
            view.txtAspirasi.setText("");
        }
        if (e.getSource() == view.btnBack) {
            this.back();
        }
    }

}
