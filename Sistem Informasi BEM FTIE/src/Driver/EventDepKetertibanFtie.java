/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.EventDepKetertibanController;
import Model.EventDepKetertibanDAO;
import View.EventDepKetertiban;

/**
 *
 * @author stu
 */
public class EventDepKetertibanFtie {
    public void start(){
        EventDepKetertiban viewEventDepKetertibanFtie = new EventDepKetertiban();
        EventDepKetertibanDAO modelEventDepKetertiban = new EventDepKetertibanDAO();
        EventDepKetertibanController ControllerPeng = new EventDepKetertibanController(viewEventDepKetertibanFtie, modelEventDepKetertiban);
        
        viewEventDepKetertibanFtie.setVisible(true);
        viewEventDepKetertibanFtie.setLocationRelativeTo(null);
        
    }
    
    public void dispose()  {
        EventDepKetertiban viewEventDepKetertibanFtie = new EventDepKetertiban();
        LoginDriver m = new LoginDriver();
        m.start();
    }
}
