
package Views.PanelesMain;

import Views.Elementos.Boton;
import Views.Elementos.Label;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import restaurant_manager.Consola;
import restaurant_manager.Restaurant_Manager;
        
public class Menu_Title {
    
    public static void IniciarComponentes_Panelmenu(){
        Boton btn_Tienda = new Boton("Info. Tienda", 0, 18, 150, 25, new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        Boton btn_Cliente = new Boton("Clientes", 0, 44, 150, 25, new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        Boton btn_Factura = new Boton("Facturas", 0, 70, 150, 25, new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        Boton btn_Producto = new Boton("Productos", 0, 96, 150, 25, new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        Boton btn_Usuario = new Boton("Usuarios", 0, 122, 150, 25, new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        Boton btn_Salir = new Boton("Salir", 0, 280, 165, 25, new Font(Font.DIALOG_INPUT, Font.BOLD + Font.ITALIC, 15));
        Views.Main.jpMenu.add(btn_Tienda);
        Views.Main.jpMenu.add(btn_Cliente);
        Views.Main.jpMenu.add(btn_Factura);
        Views.Main.jpMenu.add(btn_Producto);
        Views.Main.jpMenu.add(btn_Usuario);
        Views.Main.jpMenu.add(btn_Salir);
        Label user = new Label(Views.Main.getLoggerUser().getUsername(), 0, 0, 100, 15, new Font(Font.DIALOG_INPUT, Font.BOLD, 12), true);
        Views.Main.jpMenu.add(user);
        btn_Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Restaurant_Manager.main.setSize(400, 350);
                Views.Main.jpLoguit.setVisible(true);
                Views.Main.jpMenu.setVisible(false);
                Views.Main.jpTitulo.setVisible(false);
                Views.Main.jpViews_Store.setVisible(false);
                Views.Main.jpViews_Cliente.setVisible(false);
                Views.Main.jpViews_Factura.setVisible(false);
                Views.Main.jpViews_Producto.setVisible(false);
                Views.Main.jpViews_User.setVisible(false);
                Consola.InsertNewLog(Views.Main.getLoggerUser().getUsername(), "Ha Cerrado Sesion.");
                Views.Main.setLoggerUser(null);
            }
        });
    }

    public static void IniciarComponentes_PanelTitulo() {
        Label titulo = new Label("Restaurante Manager: " +Restaurant_Manager.restaurante.getName() , 0, 0, 485, 50, new Font(Font.DIALOG_INPUT, Font.BOLD, 16), true);
        Views.Main.jpTitulo.add(titulo);
    }
}
