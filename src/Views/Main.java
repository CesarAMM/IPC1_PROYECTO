package Views;

import Views.Elementos.*;
import Views.PanelesMain.*;
import restaurant_manager.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends JFrame{
    public static Panel jpMain, jpLoguit, jpMenu, jpTitulo, 
            jpViews_Store, jpViews_Cliente, jpViews_Factura, jpViews_Producto, jpViews_User;
    private static POO.Usuario LoggerUser = new POO.Usuario();
    private static POO.Restaurante Store = Restaurant_Manager.restaurante;
    public static Font Font_title = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
    public Font texto = new Font(Font.DIALOG_INPUT, Font.BOLD, 15);
    private static Color verde = new Color(58, 255, 0);
    private static Color rojo = new Color(247, 17, 17);
    public Main(){
        this.setTitle("Manager Restaurant");
        this.setSize(400, 350);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon("img\\img_restaurante.png").getImage());
        IniciarComponentes();
    }

    private void IniciarComponentes() {
        //Contenedor Principal
        jpMain = new Panel(new Color(0, 0, 0));
        this.getContentPane().add(jpMain);
        
        //Contenedor para el Loguit
        jpLoguit = new Panel(5, 5, 385, 310, Color.white);
        jpMain.add(jpLoguit);
        
        //Contenedores Para el resto de cosas
        jpTitulo = new Panel(5, 5, 785, 50, Color.white);
        jpMenu = new Panel(5, 60, 150, 305, Color.white);
        jpViews_Store = new Panel(160, 60, 630, 305, new Color(212, 204,204));
        jpViews_Cliente = new Panel(160, 60, 630, 305, Color.white);
        jpViews_Factura = new Panel(160, 60, 630, 305, Color.white);
        jpViews_Producto = new Panel(160, 60, 630, 305, Color.white);
        jpViews_User = new Panel(160, 60, 630, 305, Color.white);
        
        jpMain.add(jpTitulo);
        jpMain.add(jpMenu);
        jpMain.add(jpViews_Store);
        jpMain.add(jpViews_Cliente);
        jpMain.add(jpViews_Factura);
        jpMain.add(jpViews_Producto);
        jpMain.add(jpViews_User);
        
        jpLoguit.setVisible(true);
        jpMenu.setVisible(false);
        jpTitulo.setVisible(false);
        jpViews_Store.setVisible(false);
        jpViews_Cliente.setVisible(false);
        jpViews_Factura.setVisible(false);
        jpViews_Producto.setVisible(false);
        jpViews_User.setVisible(false);
        //Seccion para iniciar el restp de Componentes
        IniciarComponentesMain();
        IniciarComponentesLoguit();
    }
    private void IniciarComponentesMain() {
        Views.PanelesMain.Menu_Title.IniciarComponentes_Panelmenu();
        Views.PanelesMain.Menu_Title.IniciarComponentes_PanelTitulo();
        Views.PanelesMain.Tienda.IniciarComponentes_PanelTienda();
        Views.PanelesMain.Cliente c = new Cliente();
        c.IniciarComponentes_PanelCliente();
        Views.PanelesMain.Factura v1 = new Factura();
        v1.IniciarComponentes_PanelFactura();
        Views.PanelesMain.Producto v2 = new Views.PanelesMain.Producto();
        v2.IniciarComponentes_PanelProducto();
        Views.PanelesMain.Usuario v3 = new Usuario();
        v3.IniciarComponentes_PanelUsers();
    }
    
    private void IniciarComponentesLoguit() {
        //Seccion para labels
        Label title = new Label("Restaurante Manager", 77, 100, 230, 25, new Font(Font.DIALOG_INPUT, Font.BOLD, 20), true);
        Label alert = new Label("Credenciales Incorrectas.", 90, 230, 200, 40, new Font(Font.DIALOG_INPUT, Font.BOLD, 13), true);
        Label imgRes = new Label("img\\img_restaurante.png", 142, 20, 100, 67);
        Label icoUser = new Label("img\\ico_user.png", 100, 152, 25, 25);
        Label icoPass = new Label("img\\ico_pass.png", 100, 192, 25, 25);
        jpLoguit.add(title);
        jpLoguit.add(imgRes);
        jpLoguit.add(icoUser);
        jpLoguit.add(icoPass);
        jpLoguit.add(alert);
        alert.setVisible(false);
        //Seccion para TextBox
        TextBox txtusername = new TextBox(130, 150, 150, 30, 40, new Font(Font.DIALOG_INPUT, Font.PLAIN, 15));
        TextBoxPass txtpassword = new TextBoxPass(130, 190, 150, 30, 40, new Font(Font.DIALOG_INPUT, Font.PLAIN, 15));
        jpLoguit.add(txtusername);
        jpLoguit.add(txtpassword);
        
        //Seccion para Botones
        Boton btnIngresar = new Boton("Ingresar",250, 270, 130, 25, texto, Color.BLACK, new Color(212, 204, 204));
        jpLoguit.add(btnIngresar);
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String user = txtusername.getText();
                String pass = txtpassword.getText();
                txtpassword.setText("");
                txtusername.setText("");
                alert.setVisible(false);
                boolean estado = false;
                for (POO.Usuario usuario : Restaurant_Manager.usuarios) { 
                    if(usuario.getUsername().equals(user) && usuario.getPassword().equals(pass)){
                        estado = true;
                        LoggerUser = usuario;
                        break;
                    }
                }
                if(estado == true && LoggerUser != null){
                    Views.PanelesMain.Menu_Title.label_User.setText(LoggerUser.getUsername());
                    Views.PanelesMain.Menu_Title.label_titulo.setText("Restaurante Manager: " + Store.getName());
                    jpLoguit.setVisible(false);
                    jpMenu.setVisible(true);
                    jpTitulo.setVisible(true);
                    jpViews_Store.setVisible(true);
                    Restaurant_Manager.main.setSize(800, 400);
                    Consola.InsertNewLog(user, "Inicio Secion");
                }else{
                    alert.setVisible(true);
                    Consola.InsertNewLog(user, "Inicio de sesion faido");
                }
            }
        });
    }

    public static POO.Usuario getLoggerUser() {
        return LoggerUser;
    }

    public static void setLoggerUser(POO.Usuario LoggerUser) {
        Main.LoggerUser = LoggerUser;
    }


}
