package model;

import model.Galeri;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author awanlabs
 */
public class galeriTableModel extends AbstractTableModel{
    List<Galeri> listOfgaleri=new ArrayList<Galeri>();
    
    private final String[] header={"Judul","Nama Gambar"};
    
    public galeriTableModel(List<Galeri> listOfgaleri){
        this.listOfgaleri=listOfgaleri;
    }
    
    public void save(Galeri galeri){
        listOfgaleri.add(galeri);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }
    
    public Galeri findOne(int index){
        return listOfgaleri.get(index);
    }

    @Override
    public int getRowCount() {
        return listOfgaleri.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }
    
    @Override
    public String getColumnName(int column){
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Galeri galeri=listOfgaleri.get(rowIndex);
        
        switch(columnIndex){
            case 0:return galeri.getTitle();
            case 1:return galeri.getImage();
            default:return null;
        }
    }
    
}
