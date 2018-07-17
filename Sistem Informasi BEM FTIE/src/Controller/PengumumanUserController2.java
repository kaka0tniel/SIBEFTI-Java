package Controller;

import java.awt.event.*;
import Model.*;
import View.PengumumanUser;
import View.PengumumanUser2;
import Controller.PengumumanUserController;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HansTCS
 */
public class PengumumanUserController2 implements ActionListener {

    PengumumanUser viewUser1 = new PengumumanUser();
    PengumumanUser2 viewUser = new PengumumanUser2();
    PengumumanDAO modelPengumuman = new PengumumanDAO();
    PengumumanUserController controller = new PengumumanUserController(viewUser1, modelPengumuman);

    public PengumumanUserController2(PengumumanUser2 viewUser, PengumumanDAO modelPengumuman) {
        this.viewUser = viewUser;
        this.modelPengumuman = modelPengumuman;
        viewUser.btnView.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewUser.btnView) {
            String st = null;
            String id_pengumuman = "11";
            ResultSet rs = modelPengumuman.ViewPengumumanFtie(id_pengumuman);
            try {
                while (rs.next()) {
                    viewUser.lblJudul.setText(rs.getString(2));
                    viewUser.lblPenulis.setText(rs.getString(3));
                    viewUser.lblPeng.setText(rs.getString(4));
                }
            } catch (SQLException ex) {

            }
        }
    }
}
