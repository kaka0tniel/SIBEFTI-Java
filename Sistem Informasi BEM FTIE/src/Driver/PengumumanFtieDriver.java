package Driver;

import Controller.PengumumanBemController;
import View.frmPengumuman;
import Model.PengumumanDAO;

public class PengumumanFtieDriver {

    public void start(){
        frmPengumuman viewPengumumanFtie = new frmPengumuman();
        PengumumanDAO modelPengumuman = new PengumumanDAO();
        PengumumanBemController ControllerPeng = new PengumumanBemController(viewPengumumanFtie, modelPengumuman);

        viewPengumumanFtie.setVisible(true);
        viewPengumumanFtie.setLocationRelativeTo(null);

    }
}
