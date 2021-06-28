package Views.PanelesMain;

import Views.Elementos.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tienda {
    private static POO.Usuario user = Views.Main.getLoggerUser();
    private static POO.Restaurante stor = restaurant_manager.Restaurant_Manager.restaurante;
    public static Font f_nomal = new Font(Font.DIALOG_INPUT, Font.PLAIN, 15);
    private static Color verde = new Color(42, 184, 0);
    private static Color rojo = new Color(247, 17, 17);
    private static Color gris = new Color(212, 204, 204);
    private static TextBox txtNameStore, txtaddressStore, txtPhoneStore, txtLoadStore;
    public static void IniciarComponentes_PanelTienda() {
        //Labels
        Label namestore = new Label("Tienda:", 10, 15, 100, 15, f_nomal, false);
        Label addressstore = new Label("Direccion:", 10, 41, 100, 15, f_nomal, false);
        Label phonestore = new Label("Telefono:", 10, 67, 100, 15, f_nomal, false);
        Label loadstore = new Label("Load:", 10, 93, 100, 15, f_nomal, false);
        Views.Main.jpViews_Store.add(namestore);
        Views.Main.jpViews_Store.add(addressstore);
        Views.Main.jpViews_Store.add(phonestore);
        Views.Main.jpViews_Store.add(loadstore);
        //Combox
        txtNameStore = new TextBox(stor.getName(), 102, 10, 200, 25, f_nomal, false);
        txtaddressStore = new TextBox(stor.getAddress(), 102, 36, 200, 25, f_nomal, false);
        txtPhoneStore = new TextBox(""+stor.getPhone(), 102, 62, 150, 25, f_nomal, false);
        txtLoadStore = new TextBox(stor.getLoad(), 102, 88, 150, 25, f_nomal, false);
        Views.Main.jpViews_Store.add(txtNameStore);
        Views.Main.jpViews_Store.add(txtaddressStore);
        Views.Main.jpViews_Store.add(txtPhoneStore);
        Views.Main.jpViews_Store.add(txtLoadStore);
        //Botones
        Boton btn_edit = new Boton("Editar", 255, 250, 100, 20, f_nomal, Color.BLACK, verde);
        Boton btn_save = new Boton("Guardar", 255, 250, 100, 20, f_nomal, Color.BLACK, verde);
        Boton btn_cancel = new Boton("Cancelar", 130, 250, 120, 20, f_nomal, Color.BLACK, rojo);
        Views.Main.jpViews_Store.add(btn_edit);
        Views.Main.jpViews_Store.add(btn_save);
        Views.Main.jpViews_Store.add(btn_cancel);
        btn_save.setVisible(false);
        btn_cancel.setVisible(false);
        
        //Acciones de los Botones
        btn_edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btn_edit.setVisible(false);
                btn_cancel.setVisible(true);
                btn_save.setVisible(true);
                HabilitarCampos(true);
            }
        });
        
        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btn_edit.setVisible(true);
                btn_cancel.setVisible(false);
                btn_save.setVisible(false);
                HabilitarCampos(false);
            }
        });
        
        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btn_edit.setVisible(true);
                btn_cancel.setVisible(false);
                btn_save.setVisible(false);
                HabilitarCampos(false);
            }
        });
    }
    
    public static void HabilitarCampos(boolean estado){
        txtLoadStore.setEnabled(estado);
        txtNameStore.setEnabled(estado);
        txtPhoneStore.setEnabled(estado);
        txtaddressStore.setEnabled(estado);
    }
}
