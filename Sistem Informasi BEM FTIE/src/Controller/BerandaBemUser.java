package Controller;

import Driver.*;
import java.awt.event.*;
import Model.ProfilBem;
import View.BemFTIE;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HansTCS
 */
public class BerandaBemUser implements ActionListener {

    ProfilBem model = new ProfilBem();
    BemFTIE view = new BemFTIE();

    public BerandaBemUser(BemFTIE view, ProfilBem model) {
        this.view = view;
        this.model = model;
        view.btnPeng.addActionListener(this);
        view.btnEvnt.addActionListener(this);
        view.btnAsp.addActionListener(this);
        view.btnGaleri.addActionListener(this);
        view.btnPoll.addActionListener(this);
        view.menuLog.addActionListener(this);
        this.viewViMi();
    }

    public void forward() {
        this.view.dispose();
    }

    public void viewViMi() {
        ResultSet rs = model.ViewProfil();
        try {
            while (rs.next()) {
                view.lblVisi.setText(rs.getString(4));
                view.lblMisi1.setText(rs.getString(5));
                view.lblMisi2.setText(rs.getString(6));
                view.lblMisi3.setText(rs.getString(7));
                view.lblMisi4.setText(rs.getString(8));
            }
        } catch (SQLException ex) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnPeng) {
            this.forward();
            PengumumanUserDriver Pengumuman = new PengumumanUserDriver();
            Pengumuman.start();
        }
        if (e.getSource() == view.btnEvnt) {
            this.forward();
            EventUserDriver event = new EventUserDriver();
            event.start();
        }
        if (e.getSource() == view.btnAsp) {
            this.forward();
            AspirasiDriver aspirasi = new AspirasiDriver();
            aspirasi.start();
        }
        if (e.getSource() == view.btnGaleri) {
            this.forward();
            SaveImageDriver galeri = new SaveImageDriver();
            try {
                galeri.start();
            } catch (SQLException ex) {
                Logger.getLogger(BerandaBemUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == view.btnPoll) {
            this.forward();
            PollingBemFtieDriver polling = new PollingBemFtieDriver();
            polling.start();
        }
        if (e.getSource() == view.menuLog) {
            LoginDriver login = new LoginDriver();

            login.start();
            view.dispose();
        }
    }

}
