/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.PendidikanController;
import Model.DepartemenPendidikanDAO;
import View.frmPendidikan;
/**
 *
 * @author Otniel
 */
public class DepartemenPendidikanDriver {
    public void start(){
        frmPendidikan viewPendidikan = new frmPendidikan();
        DepartemenPendidikanDAO modelPendidikan = new DepartemenPendidikanDAO();
        PendidikanController ControllerPeng = new PendidikanController(viewPendidikan, modelPendidikan);
        
        viewPendidikan.setVisible(true);
        viewPendidikan.setLocationRelativeTo(null);
        
    }
}
