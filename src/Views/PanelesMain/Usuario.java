package Views.PanelesMain;

import Views.Elementos.Label;

public class Usuario {

    public static void IniciarComponentes_PanelUsers() {
        Label titulo = new Label("Seccion de Usuarios", 0, 5, 430, 15, Views.Main.Font_title , true);
        Views.Main.jpViews_User.add(titulo);
    }
    
}
