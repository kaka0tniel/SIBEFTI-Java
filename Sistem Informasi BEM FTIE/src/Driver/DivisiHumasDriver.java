package Driver;

import Model.ProfilBem;
import View.BerandaDivisiHumas;
import Controller.BerandaDepHumasController;
/**
 *
 * @author HansTCS
 */
public class DivisiHumasDriver {
    public void start(){
        ProfilBem model = new ProfilBem();
        BerandaDivisiHumas view = new BerandaDivisiHumas();
        BerandaDepHumasController controller = new BerandaDepHumasController(view, model);
        
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
