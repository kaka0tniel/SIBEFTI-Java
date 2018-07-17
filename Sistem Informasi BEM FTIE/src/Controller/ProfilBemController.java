package Controller;

import Driver.BerandaBemDriver;
import View.KProfilBem;
import Model.ProfilBem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author HansTCS
 */
public class ProfilBemController implements ActionListener {

    KProfilBem view = new KProfilBem();
    ProfilBem model = new ProfilBem();

    public ProfilBemController(KProfilBem view, ProfilBem model) {
        this.view = view;
        this.model = model;
        view.btnSave.addActionListener(this);
        view.btnReset.addActionListener(this);
        view.btnBack.addActionListener(this);
    }
    
    public void back(){
        this.view.dispose();
        BerandaBemDriver beranda = new BerandaBemDriver();
        beranda.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnSave) {
            String ketua = view.txtKetua.getText();
            String wakil = view.txtWakil.getText();
            String visi = view.txtVisi.getText();
            String misi1 = view.txtMisi1.getText();
            String misi2 = view.txtMisi2.getText();
            String misi3 = view.txtMisi3.getText();
            String misi4 = view.txtMisi4.getText();

            int update = model.update(ketua, wakil, visi, misi1, misi2, misi3, misi4);
            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Anda berhasil melakukan update Profil BEM FTIE");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal melakukan update Profil BEM FTIE");
            }
        } else if (e.getSource() == view.btnReset) {
            view.txtKetua.setText("");
            view.txtWakil.setText("");
            view.txtVisi.setText("");
            view.txtMisi1.setText("");
            view.txtMisi2.setText("");
            view.txtMisi3.setText("");
            view.txtMisi4.setText("");
        }
        else if(e.getSource()==view.btnBack){
            this.back();
        }
    }

}
