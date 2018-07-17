package controller;

import model.galeriDAO;
import model.Galeri;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Galeri;
import model.galeriDAO;

/**
 *
 * @author Otniel
 */
public class galeriController {
    Connection connection;
    galeriDAO galeriDAO;
    
    public galeriController(MysqlDataSource dataSource) throws SQLException{
        this.connection=dataSource.getConnection();
        galeriDAO=new galeriDAO();
        galeriDAO.setConnection(connection);
    }
    
    public void save(Galeri galeri){
        try{
            connection.setAutoCommit(false);
            galeriDAO.save(galeri);
            connection.commit();
            connection.setAutoCommit(true);
        } catch(SQLException exception){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<Galeri> findAll(){
        try {
            return galeriDAO.findAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
