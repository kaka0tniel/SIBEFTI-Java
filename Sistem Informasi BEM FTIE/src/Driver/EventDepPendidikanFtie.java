/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.EventDepPendidikanController;
import Model.EventDepPendidikanDAO;
import View.EventDepPendidikan;

/**
 *
 * @author stu
 */
public class EventDepPendidikanFtie {
    public void start(){
        EventDepPendidikan viewEventDepPendidikanFtie = new EventDepPendidikan();
        EventDepPendidikanDAO modelEventDepPendidikan = new EventDepPendidikanDAO();
        EventDepPendidikanController ControllerPeng = new EventDepPendidikanController(viewEventDepPendidikanFtie, modelEventDepPendidikan);
        
        viewEventDepPendidikanFtie.setVisible(true);
        viewEventDepPendidikanFtie.setLocationRelativeTo(null);
        
    }
    
    public void dispose()  {
        EventDepPendidikan viewEventDepPendidikanFtie = new EventDepPendidikan();
        LoginDriver m = new LoginDriver();
        m.start();
    }
}
