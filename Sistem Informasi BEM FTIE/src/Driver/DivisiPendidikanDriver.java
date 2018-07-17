package Driver;

import Model.ProfilBem;
import View.BerandaDivisiPendidikan;
import Controller.BerandaDepPendidikanController;
/**
 *
 * @author HansTCS
 */
public class DivisiPendidikanDriver {
    public void start(){
        ProfilBem model = new ProfilBem();
        BerandaDivisiPendidikan view = new BerandaDivisiPendidikan();
        BerandaDepPendidikanController controller = new BerandaDepPendidikanController(view, model);
        
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
