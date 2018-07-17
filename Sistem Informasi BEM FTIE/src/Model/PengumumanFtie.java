package Model;

/**
 *
 * @author HansTCS
 */
public class PengumumanFtie {
    private String id_pengumuman;
    private String judul;
    private String penulis;
    private String konten;
    
    public PengumumanFtie(){
        id_pengumuman = "";
        judul = "";
        penulis = "";
        konten = "";
    }

    public String getId_pengumuman() {
        return id_pengumuman;
    }

    public void setId_pengumuman(String id_pengumuman) {
        this.id_pengumuman = id_pengumuman;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }
    
    
}
