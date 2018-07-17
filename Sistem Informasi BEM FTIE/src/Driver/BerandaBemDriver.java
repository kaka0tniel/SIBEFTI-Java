package Driver;

import Model.ProfilBem;
import View.BerandaBem;
import Controller.BerandaBemController;
/**
 *
 * @author HansTCS
 */
public class BerandaBemDriver {
    public void start(){
        ProfilBem model = new ProfilBem();
        BerandaBem view = new BerandaBem();
        BerandaBemController controller = new BerandaBemController(view, model);
        
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
