package Views.PanelesMain;

import Views.Elementos.Label;

public class Producto {

    public static void IniciarComponentes_PanelProducto() {
        Label titulo = new Label("Seccion de Producto", 0, 5, 430, 15, Views.Main.Font_title , true);
        Views.Main.jpViews_Producto.add(titulo);
    }
    
}
