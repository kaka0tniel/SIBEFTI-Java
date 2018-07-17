package Driver;

/**
 *
 * @author HansTCS
 */
import Model.PollingBemModel;
import Controller.PollingBemController;
import View.PollingBemFtie;

public class PollingBemFtieDriver {
    public void start(){
        PollingBemFtie PollingBem = new PollingBemFtie();
        PollingBemModel Model = new PollingBemModel();
        PollingBemController Controller = new PollingBemController(PollingBem, Model);

        PollingBem.setVisible(true);
        PollingBem.setLocationRelativeTo(null);
    }
    
}
