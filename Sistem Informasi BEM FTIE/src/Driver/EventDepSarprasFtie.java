/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.EventDepSarprasController;
import Model.EventDepSarprasDAO;
import View.EventDepSarpras;

/**
 *
 * @author stu
 */
public class EventDepSarprasFtie {
    public void start(){
        EventDepSarpras viewEventDepSarprasFtie = new EventDepSarpras();
        EventDepSarprasDAO modelEventDepSarpras = new EventDepSarprasDAO();
        EventDepSarprasController ControllerPeng = new EventDepSarprasController(viewEventDepSarprasFtie, modelEventDepSarpras);
        
        viewEventDepSarprasFtie.setVisible(true);
        viewEventDepSarprasFtie.setLocationRelativeTo(null);
        
    }
    
    public void dispose()  {
        EventDepSarpras viewEventDepSarprasFtie = new EventDepSarpras();
        LoginDriver m = new LoginDriver();
        m.start();
    }
}
