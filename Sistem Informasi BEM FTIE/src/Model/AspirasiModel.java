package Model;

import java.sql.*;

/**
 *
 * @author HansTCS
 */
public class AspirasiModel {
    private int Nim;
    private String aspirasi;

    public int getNim() {
        return Nim;
    }

    public void setNim(int Nim) {
        this.Nim = Nim;
    }

    public String getAspirasi() {
        return aspirasi;
    }

    public void setAspirasi(String aspirasi) {
        this.aspirasi = aspirasi;
    }
    
    public String insert(int nim, String aspirasi){
        String insert = null;
        try{
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement("INSERT INTO aspirasi (nim, aspirasi) VALUES(?,?);");
            ps.setInt(1, nim);
            ps.setString(2, aspirasi);
            
            int aspInserted = ps.executeUpdate();
            
            if(aspInserted > 0){
                insert = "Terimakasih atas aspirasi anda";
            }
        }
        catch(Exception e){
            
        }
        return insert;
    }
}
