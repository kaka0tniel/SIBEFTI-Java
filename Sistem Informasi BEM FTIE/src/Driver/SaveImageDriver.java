package Driver;

import controller.galeriController;
import view.UploadImageFrame;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;

/**
 *
 * @author awanlabs
 */
public class SaveImageDriver {
    
    private static galeriController bookController;
    
    public static galeriController getgaleriController(){
        return bookController;
    }

    public void start() throws SQLException {
         MysqlDataSource dataSource=new MysqlDataSource();
            dataSource.setUser("root");
            dataSource.setPassword("");
            dataSource.setServerName("localhost");
            dataSource.setDatabaseName("bemftie");
            
            bookController=new galeriController(dataSource);
        
        new UploadImageFrame().setVisible(true);
        new UploadImageFrame().setLocationRelativeTo(null);
    }
}
