package Driver;

import Model.ProfilBem;
import View.BerandaDivisiKetertiban;
import Controller.BerandaDepKetertibanController;
/**
 *
 * @author HansTCS
 */
public class DivisiKetertibanDriver {
    public void start(){
        ProfilBem model = new ProfilBem();
        BerandaDivisiKetertiban view = new BerandaDivisiKetertiban();
        BerandaDepKetertibanController controller = new BerandaDepKetertibanController(view, model);
        
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
