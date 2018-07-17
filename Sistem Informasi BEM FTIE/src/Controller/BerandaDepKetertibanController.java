package Controller;

import Model.ProfilBem;
import View.BerandaDivisiKetertiban;
import java.awt.event.*;
import java.sql.*;
import Driver.*;

/**
 *
 * @author HansTCS
 */
public class BerandaDepKetertibanController implements ActionListener {

    ProfilBem model = new ProfilBem();
    BerandaDivisiKetertiban view = new BerandaDivisiKetertiban();

    public BerandaDepKetertibanController(BerandaDivisiKetertiban view, ProfilBem model) {
        this.view = view;
        this.model = model;
        view.menuEvt.addActionListener(this);
        view.menuPengurus.addActionListener(this);
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
        if (e.getSource() == view.menuEvt) {
            EventDepKetertibanFtie ketertiban = new EventDepKetertibanFtie();
            ketertiban.start();
            this.forward();
        }
        if (e.getSource() == view.menuPengurus) {
            DepartemenKetertibanDriver keter = new DepartemenKetertibanDriver();
            keter.start();
            this.forward();
        }
        if (e.getSource() == view.menuLog) {
            LoginDriver login = new LoginDriver();

            login.start();
            view.dispose();
        }
    }

}
