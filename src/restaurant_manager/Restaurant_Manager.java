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
        do{
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
                    Consola.InsertNewLog(user, "Inicio de sesion faido");
                }else if(!(user.equals("") && pass.equals(""))){
                    Consola.InsertNewLog(user, "Inicio Secion");
                }
            } while (estado);
            estado = true;
            int index = 0;
            do {                
                System.out.println(""
                    + "\n*************************************"
                    + "\n** 1) Informacion del Restaurante  **"
                    + "\n** 2) Usuarios                     **"
                    + "\n** 3) Productos                    **"
                    + "\n** 4) Clientes                     **"
                    + "\n** 5) Facturas                     **"
                    + "\n** 6) Guardar Cambios              **"
                    + "\n** 7) Salir                        **"
                    + "\n*************************************");
                do {
                    index = Consola.inputInt("Ingrese una opcion\n--> ");
                } while (index == 0);
                switch(index){
                    case 1:
                        System.out.println("Informacion del Restaurante: \n"+restaurante.toString() +"\n");
                        break;
                    case 2:
                        Menu_Usuarios();
                        break;
                    case 3:
                        Menu_Productos();
                        break;
                    case 4:
                        Menu_Clientes();
                        break;
                    case 5:
                        Menu_Facturas();
                        break;
                    case 6:
                        Menu_Cambios();
                        break;
                    case 7:
                        System.out.println("**   Gracias Por ingresar   **");
                        Consola.InsertNewLog(user, "Cerro Secion");
                        break;
                    default:
                        System.out.println("*** Has ingresado una opcion Fuera de Rango  ***");
                        break;
                }
            } while (index < 7);
        }while(estado);
    }
    
    private static void Menu_Usuarios(){
        int index = 0;
        do {            
            System.out.println(""
                    + "\n\t**************************"
                    + "\n\t** 1) Listar Usuarios   **"
                    + "\n\t** 2) Eliminar Usuario  **"
                    + "\n\t** 3) Ver Usuario       **"
                    + "\n\t** 4) Regresar          **"
                    + "\n\t**************************");
            index = Consola.inputInt("\tIngrese una Opcion\n\t-->");
            switch(index){
                case 1:
                    Cesar_Funciones.Listar(usuarios);
                    break;
                case 2:
                    Cesar_Funciones.EliminarUsuario(user);
                    break;
                case 3:
                    Cesar_Funciones.MostrarUsuario(user);
                    break;
                default:
                    System.out.println("*** Has ingresado una Opcion Fuera del rago   ****");
                    break;
            }
        } while (index == 0 || index < 4);
    }
    
    private static void Menu_Productos(){
        int index = 0;
        do {            
            System.out.println(""
                    + "\n\t**************************"
                    + "\n\t** 1) Listar Productos  **"
                    + "\n\t** 2) Eliminar Productos**"
                    + "\n\t** 3) Ver Productos     **"
                    + "\n\t** 4) Regresar          **"
                    + "\n\t**************************");
            index = Consola.inputInt("\tIngrese una Opcion\n\t-->");
            switch(index){
                case 1:
                    Cesar_Funciones.Listar(productos);
                    break;
                case 2:
                    Cesar_Funciones.EliminarProducto(user);
                    break;
                case 3:
                    Cesar_Funciones.MostrarProductos(user);
                    break;
                default:
                    System.out.println("*** Has ingresado una Opcion Fuera del rago   ****");
                    break;
            }
        } while (index == 0 || index < 4);
    }
    
    private static void Menu_Clientes(){
        int index = 0;
        do {            
            System.out.println(""
                    + "\n\t**************************"
                    + "\n\t** 1) Listar Clientes   **"
                    + "\n\t** 2) Eliminar Clientes **"
                    + "\n\t** 3) Ver Clientes      **"
                    + "\n\t** 4) Regresar          **"
                    + "\n\t**************************");
            index = Consola.inputInt("\tIngrese una Opcion\n\t-->");
            switch(index){
                case 1:
                    Cesar_Funciones.Listar(clientes);
                    break;
                case 2:
                    Cesar_Funciones.EliminarCliente(user);
                    break;
                case 3:
                    Cesar_Funciones.MostrarCliente(user);
                    break;
                default:
                    System.out.println("*** Has ingresado una Opcion Fuera del rago   ****");
                    break;
            }
        } while (index == 0 || index < 4);
    }
    
    private static void Menu_Facturas(){
        int index = 0;
        do {            
            System.out.println(""
                    + "\n\t**************************"
                    + "\n\t** 1) Listar Facturas   **"
                    + "\n\t** 2) Eliminar Facturas **"
                    + "\n\t** 3) Ver Facturas      **"
                    + "\n\t** 4) Regresar          **"
                    + "\n\t**************************");
            index = Consola.inputInt("\tIngrese una Opcion\n\t-->");
            switch(index){
                case 1:
                    Cesar_Funciones.Listar(facturas);
                    break;
                case 2:
                    Cesar_Funciones.EliminarFactura(user);
                    break;
                case 3:
                    Cesar_Funciones.MostrarFactura(user);
                    break;
                default:
                    System.out.println("*** Has ingresado una Opcion Fuera del rago   ****");
                    break;
            }
        } while (index == 0 || index < 4);
    }
    
    private static void Menu_Cambios(){
        int index = 0;
        do {            
            System.out.println(""
                    + "\n\t**********************************"
                    + "\n\t** 1) Guardar Cambios JSON      **"
                    + "\n\t** 2) Guardar Cambios Binarios  **"
                    + "\n\t** 3) Regresar                  **"
                    + "\n\t**********************************");
            index = Consola.inputInt("\tIngrese una Opcion\n\t-->");
            switch(index){
                case 1:
                    Cesar_Funciones.JsonDatos();
                    Consola.InsertNewLog(user, "A guardado los datos en Formato JSON");
                    break;
                case 2:
                    Cesar_Funciones.SerealizarDatos();
                    Consola.InsertNewLog(user, "A guardado los datos en Formato Binario");
                    break;
                default:
                    System.out.println("*** Has ingresado una Opcion Fuera del rago   ****");
                    break;
            }
        } while (index == 0 || index > 3);
    }
}
