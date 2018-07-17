package Driver;

import Model.ProfilBem;
import View.BemFTIE;
import Controller.BerandaBemUser;

/**
 *
 * @author HansTCS
 */
public class BerandaBemUserDriver {

    public void start() {
        ProfilBem model = new ProfilBem();
        BemFTIE view = new BemFTIE();
        BerandaBemUser controller = new BerandaBemUser(view, model);
        
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
