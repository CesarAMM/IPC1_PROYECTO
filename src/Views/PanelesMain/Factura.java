package Views.PanelesMain;

import Views.Elementos.Label;

public class Factura {

    public static void IniciarComponentes_PanelFactura() {
        Label titulo = new Label("Seccion de Facturas", 0, 5, 430, 15, Views.Main.Font_title , true);
        Views.Main.jpViews_Factura.add(titulo);
    }
    
}
