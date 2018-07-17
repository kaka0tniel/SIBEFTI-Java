/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.EventBemController;
import Model.EventDAO;
import View.frmEvent;

/**
 *
 * @author stu
 */
public class EventFtieDriver {
    public void start(){
        frmEvent viewEventFtie = new frmEvent();
        EventDAO modelEvent = new EventDAO();
        EventBemController ControllerPeng = new EventBemController(viewEventFtie, modelEvent);
        
        viewEventFtie.setVisible(true);
        viewEventFtie.setLocationRelativeTo(null);
        
    }
}
