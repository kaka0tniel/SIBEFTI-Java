package model;

import model.Galeri;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author awanlabs
 */
public class galeriDAO {
    Connection connection;
    PreparedStatement preparedStatement;
    
    public void setConnection(Connection connection){
        this.connection=connection;
    }
    
    public void save(Galeri galeri) throws SQLException{
            preparedStatement=connection.prepareStatement("insert into galeri(title,image) values(?,?)");
            preparedStatement.setString(1, galeri.getTitle());
            preparedStatement.setString(2, galeri.getImage());
            preparedStatement.executeUpdate();        
    }
    
    public Galeri findOne(Integer id) throws SQLException{
        Galeri galeri=new Galeri();
        
        preparedStatement=connection.prepareStatement("SELECT * from galeri where id=?");
        preparedStatement.setInt(1, id);
        ResultSet rs=preparedStatement.executeQuery();
                    
        while(rs.next()){
            galeri.setId(rs.getInt("id"));
            galeri.setTitle(rs.getString("title"));
            galeri.setImage(rs.getString("image"));
        }
        return galeri;
    }
    
    public List<Galeri> findAll() throws SQLException{
        List<Galeri> listOfgaleri=new ArrayList<Galeri>();
                     
        preparedStatement=connection.prepareStatement("select * from galeri");
        ResultSet rs=preparedStatement.executeQuery();
            
        while(rs.next()){
            Galeri galeri=new Galeri();
            galeri.setId(rs.getInt("id"));
            galeri.setTitle(rs.getString("title"));
            galeri.setImage(rs.getString("image"));
            listOfgaleri.add(galeri);
        }
        return listOfgaleri;
    }
}
