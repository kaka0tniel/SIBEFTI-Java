package Model;

import java.sql.*;

/**
 *
 * @author HansTCS
 */
public class ProfilBem {

    private String ketua;
    private String wakil;
    private String visi;
    private String misi1;
    private String misi2;
    private String misi3;
    private String misi4;

    public String getKetua() {
        return ketua;
    }

    public void setKetua(String ketua) {
        this.ketua = ketua;
    }

    public String getWakil() {
        return wakil;
    }

    public void setWakil(String wakil) {
        this.wakil = wakil;
    }

    public String getVisi() {
        return visi;
    }

    public void setVisi(String visi) {
        this.visi = visi;
    }

    public String getMisi1() {
        return misi1;
    }

    public void setMisi1(String misi1) {
        this.misi1 = misi1;
    }

    public String getMisi2() {
        return misi2;
    }

    public void setMisi2(String misi2) {
        this.misi2 = misi2;
    }

    public String getMisi3() {
        return misi3;
    }

    public void setMisi3(String misi3) {
        this.misi3 = misi3;
    }

    public String getMisi4() {
        return misi4;
    }

    public void setMisi4(String misi4) {
        this.misi4 = misi4;
    }

    public int update(String ketua, String wakil, String visi, String misi1, String misi2, String misi3, String misi4) {
        int rowUpdated = 0;
        try {
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement("UPDATE profilbem_ftie SET ketua=?, wakil_ketua=?, visi=?, misi1=?, misi2=?, misi3=?, misi4=?;");
            ps.setString(1, ketua);
            ps.setString(2, wakil);
            ps.setString(3, visi);
            ps.setString(4, misi1);
            ps.setString(5, misi2);
            ps.setString(6, misi3);
            ps.setString(7, misi4);
            
            rowUpdated = ps.executeUpdate();
        } catch (Exception ex) {

        }
        return rowUpdated;
    }
    
    public ResultSet ViewProfil(){
        ResultSet rs = null;
        try{
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement("SELECT * FROM profilbem_ftie;");
            rs = ps.executeQuery();
        }
        catch(SQLException ex){
        }
        return rs;
    }
}
