package Views.PanelesMain;

import Views.Elementos.Label;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Factura {
    public static JTable tbl;
    public static DefaultTableModel dtm;
    public static void IniciarComponentes_PanelFactura() {
        Label titulo = new Label("Seccion de Facturas", 0, 5, 630, 15, Views.Main.Font_title , true);
        Views.Main.jpViews_Factura.add(titulo);
    }
    
}
