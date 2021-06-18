package restaurant_manager;

import POO.*;
import java.util.ArrayList;

public class Restaurant_Manager {
    public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Factura> facturas = new ArrayList<Factura>();
    public static ArrayList<Producto> productos = new ArrayList<Producto>();
    private static String user = "";
    private static String pass = "";
    private static Restaurante restaurante;
    public static void main(String[] args) {
        restaurante = Cesar_Funciones.InitDownloadData();
        Iniciar();
    }
    
    public static void Iniciar(){
        boolean estado = true;
        do {
            user = Consola.inputString("Ingrese Usuario: ");
            pass = Consola.inputString("Ingrese Contraseña: ");
            for (Usuario usuario : usuarios) {
                if(usuario.getUsername().equals(user) && usuario.getPassword().equals(pass)){
                    estado = false;
                }
            }
            if(estado){
                System.out.println("-->Error de inicio<--");
                Consola.InsertNewLog(user, "Inicio de sesión faido");
            }else if(!(user.equals("") && pass.equals(""))){
                Consola.InsertNewLog(user, "Inicio Seción");
            }
        } while (estado);
    }
}
