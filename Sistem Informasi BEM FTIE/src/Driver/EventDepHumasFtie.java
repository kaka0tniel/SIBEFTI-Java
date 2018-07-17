/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.EventDepHumasController;
import Model.EventDepHumasDAO;
import View.EventDepHumas;

/**
 *
 * @author stu
 */
public class EventDepHumasFtie {
    public void start(){
        EventDepHumas viewEventDepHumasFtie = new EventDepHumas();
        EventDepHumasDAO modelEventDepHumas = new EventDepHumasDAO();
        EventDepHumasController ControllerPeng = new EventDepHumasController(viewEventDepHumasFtie, modelEventDepHumas);
        
        viewEventDepHumasFtie.setVisible(true);
        viewEventDepHumasFtie.setLocationRelativeTo(null);
        
    }
    
    public void dispose()  {
        EventDepHumas viewEventDepHumasFtie = new EventDepHumas();
        LoginDriver m = new LoginDriver();
        m.start();
    }
}
