package Driver;

import Controller.LoginController;
import View.Login;
import Model.LoginModel;

/**
 *
 * @author HansTCS
 */
public class LoginDriver {

    public void start() {
        Login view = new Login();
        LoginModel model = new LoginModel();
        LoginController controller = new LoginController(view, model);
        
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
