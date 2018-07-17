package Driver;

import Controller.PengumumanUserController;
import Model.PengumumanDAO;
import View.PengumumanUser;

/**
 *
 * @author HansTCS
 */
public class PengumumanUserDriver {
    public void start(){
        PengumumanUser view = new PengumumanUser();
        PengumumanDAO model = new PengumumanDAO();
        PengumumanUserController controller = new PengumumanUserController(view, model);
        
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
