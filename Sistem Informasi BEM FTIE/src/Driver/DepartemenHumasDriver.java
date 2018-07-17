/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.HumasController;
import Model.DepartemenHumasDAO;
import View.frmHumas;
/**
 *
 * @author Otniel
 */
public class DepartemenHumasDriver {
    public void start(){
        frmHumas viewHumas = new frmHumas();
        DepartemenHumasDAO modelHumas = new DepartemenHumasDAO();
        HumasController ControllerPeng = new HumasController(viewHumas, modelHumas);
        
        viewHumas.setVisible(true);
        viewHumas.setLocationRelativeTo(null);
        
    }
}
