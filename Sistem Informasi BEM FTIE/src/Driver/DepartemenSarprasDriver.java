/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.SarprasController;
import Model.DepartemenSarprasDAO;
import View.frmSarpras;
/**
 *
 * @author Otniel
 */
public class DepartemenSarprasDriver {
    public void start(){
        frmSarpras viewSarpras = new frmSarpras();
        DepartemenSarprasDAO modelSarpras = new DepartemenSarprasDAO();
        SarprasController ControllerPeng = new SarprasController(viewSarpras, modelSarpras);
        
        viewSarpras.setVisible(true);
        viewSarpras.setLocationRelativeTo(null);
        
    }
}
