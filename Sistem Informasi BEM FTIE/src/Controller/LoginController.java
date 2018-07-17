package Controller;

import java.awt.event.*;
import View.Login;
import Model.LoginModel;
import java.sql.*;
import javax.swing.JOptionPane;
import Driver.*;

/**
 *
 * @author HansTCS
 */
public class LoginController implements ActionListener {

    Login view = new Login();
    LoginModel model = new LoginModel();

    public LoginController(Login view, LoginModel model) {
        this.view = view;
        this.model = model;
        view.btnLogin.addActionListener(this);
    }

    public void forward(){
        this.view.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnLogin) {
            //JOptionPane.showMessageDialog(null, "TEST BERHASIL");
            String nim = view.txtUsername.getText();
            int Nim = Integer.parseInt(nim);
            String password = view.txtPass.getText();
            ResultSet rs = model.Logins(Nim, password);
            try {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Wellcome");
                    this.forward();
                    if (rs.getString(6).equals("1")) {
                        AdminDriver admin = new AdminDriver();
                        admin.start();
                    } else if (rs.getString(6).equals("2")) {
                        System.out.println("Halaman BEM FTIE");
                        BerandaBemDriver halamanBem = new BerandaBemDriver();
                        halamanBem.start();
                    } else if (rs.getString(6).equals("3")) {
                        System.out.println("Halaman Mahasiswa FTIE");
                        BerandaBemUserDriver mahasiswa = new BerandaBemUserDriver();
                        mahasiswa.start();
                    } else if (rs.getString(6).equals("4")) {
                        System.out.println("Halaman Divisi Humas");
                        DivisiHumasDriver humas = new DivisiHumasDriver();
                        humas.start();
                    } else if (rs.getString(6).equals("5")) {
                        System.out.println("Halaman Divisi Sarpras");
                        DivisiSarprasDriver sarpras = new DivisiSarprasDriver();
                        sarpras.start();
                    } else if (rs.getString(6).equals("6")) {
                        System.out.println("Halaman Divisi Ketertiban");
                        DivisiKetertibanDriver ketertiban = new DivisiKetertibanDriver();
                        ketertiban.start();
                    } else if (rs.getString(6).equals("7")) {
                        System.out.println("Halaman Divisi Pendidikan");
                        DivisiPendidikanDriver ketertiban = new DivisiPendidikanDriver();
                        ketertiban.start();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Username atau password masih salah", "Wrong Credential", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

}
