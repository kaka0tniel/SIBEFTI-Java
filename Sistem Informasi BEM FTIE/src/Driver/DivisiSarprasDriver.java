package Driver;

import Model.ProfilBem;
import View.BerandaDivisiSarpras;
import Controller.BerandaDepSarprasController;
/**
 *
 * @author HansTCS
 */
public class DivisiSarprasDriver {
    public void start(){
        ProfilBem model = new ProfilBem();
        BerandaDivisiSarpras view = new BerandaDivisiSarpras();
        BerandaDepSarprasController controller = new BerandaDepSarprasController(view, model);
        
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
