/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.MahasiswaController;
import Model.MahasiswaDAO;
import View.frmMahasiswa;
/**
 *
 * @author Otniel
 */
public class AdminDriver {
    public void start(){
        frmMahasiswa viewMahasiswaFtie = new frmMahasiswa();
        MahasiswaDAO modelMahasiswa = new MahasiswaDAO();
        MahasiswaController ControllerPeng = new MahasiswaController(viewMahasiswaFtie, modelMahasiswa);
        
        viewMahasiswaFtie.setVisible(true);
        viewMahasiswaFtie.setLocationRelativeTo(null);
        
    }
}
