package Controller;

import Driver.*;
import Model.ProfilBem;
import View.BerandaBem;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HansTCS
 */
public class BerandaBemController implements ActionListener {

    ProfilBem model = new ProfilBem();
    BerandaBem view = new BerandaBem();

    public BerandaBemController(BerandaBem view, ProfilBem model) {
        this.view = view;
        this.model = model;
        view.menuProfil.addActionListener(this);
        view.menuGal.addActionListener(this);
        view.menuEvt.addActionListener(this);
        view.menuPeng.addActionListener(this);
        view.menuLog.addActionListener(this);
        this.viewVimi();
    }

    public void forward() {
        this.view.dispose();
    }

    public void viewVimi() {
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
        if (e.getSource() == view.menuPeng) {
            PengumumanFtieDriver kelolaPengumuman = new PengumumanFtieDriver();
            kelolaPengumuman.start();
            this.forward();
        }
        if (e.getSource() == view.menuProfil) {
            ProfilBemDriver kelolaProfil = new ProfilBemDriver();
            kelolaProfil.start();
            this.forward();
        }
        if (e.getSource() == view.menuEvt) {
            EventFtieDriver kelolaEvent = new EventFtieDriver();
            kelolaEvent.start();
            this.forward();
        }
        if (e.getSource() == view.menuGal) {
            System.out.println("Halaman Galeri");
            SaveImageDriver galeri = new SaveImageDriver();
            try {
                galeri.start();
            } catch (SQLException ex) {
                Logger.getLogger(BerandaBemController.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.forward();
        }
        if (e.getSource() == view.menuLog) {
            LoginDriver login = new LoginDriver();

            login.start();
            view.dispose();
        }
    }

}
