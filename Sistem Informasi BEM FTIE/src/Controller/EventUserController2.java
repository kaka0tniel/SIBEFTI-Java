package Controller;

import java.awt.event.*;
import Model.*;
import View.*;
import Controller.PengumumanUserController;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Driver.*;

/**
 *
 * @author HansTCS
 */
public class EventUserController2 implements ActionListener {

    EventUser viewUser = new EventUser();
    EventUser2 viewUser1 = new EventUser2();
    EventDAO modelEvent = new EventDAO();
    EventUserController controller = new EventUserController(viewUser, modelEvent);

    public EventUserController2(EventUser2 viewUser, EventDAO modelPengumuman) {
        this.viewUser1 = viewUser;
        this.modelEvent = modelEvent;
        viewUser1.btnView.addActionListener(this);
        viewUser1.btnBack.addActionListener(this);
    }

    public void back(){
        this.viewUser1.dispose();
        EventUserDriver previous = new EventUserDriver();
        previous.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewUser1.btnView) {
            String st = null;
            String id_pengumuman = "2";
            ResultSet rs = modelEvent.ViewEventFtie(id_pengumuman);
            try {
                while (rs.next()) {
                    viewUser1.lblJudul.setText(rs.getString(2));
                    viewUser1.lblPenulis.setText(rs.getString(4));
                    viewUser1.lblPeng.setText(rs.getString(5));
                }
            } catch (SQLException ex) {

            }
        }
        if(e.getSource()==viewUser1.btnBack){
            this.back();
        }
    }
}
