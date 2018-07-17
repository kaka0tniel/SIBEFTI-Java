/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.KetertibanController;
import Model.DepartemenKetertibanDAO;
import View.frmKetertiban;
/**
 *
 * @author Otniel
 */
public class DepartemenKetertibanDriver {
    public void start(){
        frmKetertiban viewKetertiban = new frmKetertiban();
        DepartemenKetertibanDAO modelKetertiban = new DepartemenKetertibanDAO();
        KetertibanController ControllerPeng = new KetertibanController(viewKetertiban, modelKetertiban);

        viewKetertiban.setVisible(true);
        viewKetertiban.setLocationRelativeTo(null);
        
    }
}
