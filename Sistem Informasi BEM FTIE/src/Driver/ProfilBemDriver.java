package Driver;

import View.KProfilBem;
import Model.ProfilBem;
import Controller.ProfilBemController;

/**
 *
 * @author HansTCS
 */
public class ProfilBemDriver {

    public void start(){
        KProfilBem view = new KProfilBem();
        ProfilBem model = new ProfilBem();
        ProfilBemController controller = new ProfilBemController(view, model);
        
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
