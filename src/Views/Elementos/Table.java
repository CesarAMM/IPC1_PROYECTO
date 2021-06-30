package Views.Elementos;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table extends JScrollPane{
    private String [] titulos;
    private Object [][] datos;
    private int xpos, ypos;
    private int xpix, ypix;

    public Table(String[] titulos, Object[][] datos, int xpos, int ypos, int xpix, int ypix) {
        this.titulos = titulos;
        this.datos = datos;
        this.xpos = xpos;
        this.ypos = ypos;
        this.xpix = xpix;
        this.ypix = ypix;
        DefaultTableModel dtm = new DefaultTableModel(datos, titulos);
        JTable table = new JTable(dtm);
        this.setColumnHeaderView(table);
        this.setBounds(xpos, ypos, xpix, ypix);
    }
    
    
    
}
