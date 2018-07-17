package Driver;

import View.PengumumanUser2;
import Controller.PengumumanUserController2;
import Model.PengumumanDAO;

/**
 *
 * @author HansTCS
 */
public class PengumumanUserDriver2 {
    public void start(){
        PengumumanUser2 view = new PengumumanUser2();
        PengumumanDAO model = new PengumumanDAO();
        PengumumanUserController2 controller = new PengumumanUserController2(view, model);
        
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
