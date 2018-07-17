package Driver;

import View.EventUser2;
import Controller.EventUserController2;
import Model.EventDAO;

/**
 *
 * @author HansTCS
 */
public class EventUserDriver2 {
    public void start(){
        EventUser2 view = new EventUser2();
        EventDAO model = new EventDAO();
        EventUserController2 controller = new EventUserController2(view, model);
        
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
