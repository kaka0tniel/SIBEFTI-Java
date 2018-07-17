/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.EventUserController;
import Model.EventDAO;
import View.EventUser;

/**
 *
 * @author stu
 */
public class EventUserDriver {
    public void start(){
        EventUser viewEventFtie = new EventUser();
        EventDAO modelEvent = new EventDAO();
        EventUserController ControllerPeng = new EventUserController(viewEventFtie, modelEvent);
        
        viewEventFtie.setVisible(true);
        viewEventFtie.setLocationRelativeTo(null);
        
    }
}
