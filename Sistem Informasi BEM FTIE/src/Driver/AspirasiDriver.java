package Driver;

import Model.AspirasiModel;
import Controller.AspirasiController;
import View.AspirasiMahasiswa;

/**
 *
 * @author HansTCS
 */
public class AspirasiDriver {

    public void start() {
        AspirasiModel model = new AspirasiModel();
        AspirasiMahasiswa view = new AspirasiMahasiswa();
        AspirasiController controller = new AspirasiController(view, model);
        
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
