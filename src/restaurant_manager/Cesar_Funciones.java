package restaurant_manager;

import POO.*;
import com.google.gson.Gson;
import java.util.ArrayList;

public class Cesar_Funciones {
    
    public static Restaurante InitDownloadData(){
        String paht_json = "PruebasProyecto\\Json\\";//Para ir a buscar los datos del Json
        String paht_bin = "PruebasProyecto\\Bin\\";//Para ir a buscar datos Binarios
        //Iniciamos con el config.json
        String config = Consola.readFile(paht_json + "config.json");
        Gson gson = new Gson();
        Restaurante restaurante = gson.fromJson(config, Restaurante.class);
        if(restaurante.getLoad().equals("json")){
            CargaDatos_Json(paht_json);
        }else if(restaurante.getLoad().equals("bin")){
            CargaDatos_Bin(paht_bin);
        }
        return restaurante;
    }
    
    private static void CargaDatos_Json(String paht){
        Gson gson = new Gson();
        String datos_users = Consola.readFile(paht + "users.json");
        String datos_clients = Consola.readFile(paht+ "clients.json");
        String datos_invoices = Consola.readFile(paht + "invoices.json");
        String datos_products = Consola.readFile(paht+ "products.json");
        Usuario[] users= gson.fromJson(datos_users, Usuario[].class);
        Producto[] products = gson.fromJson(datos_products, Producto[].class);
        Cliente[] clientes = gson.fromJson(datos_clients, Cliente[].class);
        Factura[] facturas = gson.fromJson(datos_invoices, Factura[].class);
        boolean estado = false;
        for (int i = 0; i < users.length; i++) {
            estado = true;
            for (Usuario usuario : Restaurant_Manager.usuarios) {
                if(usuario.getUsername().equals(users[i].getUsername())){
                    estado = false;
                    Consola.InsertNewError("USERS", "El id: "+ users[i].getUsername()+ " ya existe, se omitio el registro");
                    break;
                }
            }
            if(estado == true){
                Restaurant_Manager.usuarios.add(users[i]);
            }
        }
        for (int i = 0; i < products.length; i++) {
            estado = true;
            for (Producto producto : Restaurant_Manager.productos) {
                if(producto.getId() == products[i].getId()){
                    estado = false;
                    Consola.InsertNewError("PRODUCTS", "El id: "+ products[i].getId()+ " ya existe, se omitio el registro");
                    break;
                }
            }
            if(estado == true){
                Restaurant_Manager.productos.add(products[i]);
            }
        }
        for (int i = 0; i < clientes.length; i++) {
            estado = true;
            for (Cliente cliente : Restaurant_Manager.clientes) {
                if(cliente.getId() == clientes[i].getId()){
                    estado = false;
                    Consola.InsertNewError("CLIENTS", "El id: "+ clientes[i].getId()+ " ya existe, se omitio el registro");
                    break;
                }
            }
            if(estado == true){
                Restaurant_Manager.clientes.add(clientes[i]);
            }
        }
        for (int i = 0; i < facturas.length; i++) {
            estado = true;
            for (Factura factura : Restaurant_Manager.facturas) {
                if(factura.getClient()== facturas[i].getClient()){
                    estado = false;
                    Consola.InsertNewError("INVOICES", "El id: "+ facturas[i].getClient()+ " ya existe, se omitio el registro");
                    break;
                }
            }
            if(estado == true){
                Restaurant_Manager.facturas.add(facturas[i]);
            }
        }
    }
    
    private static void CargaDatos_Bin(String paht){
        
    }
    
    public static void Listar(ArrayList objeto){
        for (Object object : objeto) {
            System.out.print(object.toString());
        }
    }
    
    public static void MostrarUsuario(){
        boolean buscador = true;
        String usuariodelete = Consola.inputString("\tIngrese el Usuario a eliminar\n\t-->");
        for (Usuario usuario : Restaurant_Manager.usuarios) {
            if(usuario.getUsername().equals(usuariodelete)){
                usuario.toString();
                buscador = false;
                break;
            }
        }
        if(buscador == true){
            System.out.println("***   El usuario '"+ usuariodelete+"' no existe.   ***");
            
        }
    }
    
    public static void EliminarUsuario(String User) {
        boolean buscador = true;
        String usuariodelete = Consola.inputString("\tIngrese el Usuario a eliminar\n\t-->");
        for (Usuario usuario : Restaurant_Manager.usuarios) {
            if(usuario.getUsername().equals(usuariodelete)){
                Restaurant_Manager.usuarios.remove(usuario);
                buscador = false;
                break;
            }
        }
        if(buscador){
            System.out.println("\t***   No se encontro el Usuario   ***");
        }else{
            Consola.InsertNewLog(User, "Elimino el usuario '"+usuariodelete+"'");
        }
    }
    
    public static void EliminarProducto(String User) {
        boolean buscador = true;
        int id = Consola.inputInt("\tIngrese el Id del producto a eliminar\n\t-->");
        for (Producto producto : Restaurant_Manager.productos) {
            if(producto.getId() == id){
                Restaurant_Manager.productos.remove(producto);
                buscador = false;
                break;
            }
        }
        if(buscador){
            System.out.println("\t***   No se encontro el Producto  ***");
        }else{
            Consola.InsertNewLog(User, "Elimino el producto con el Id: '"+id+"'");
        }
    }
    
    public static void EliminarCliente(String User) {
        boolean buscador = true;
        int id = Consola.inputInt("\tIngrese el Id del Cliente a eliminar\n\t-->");
        for (Cliente cliente : Restaurant_Manager.clientes) {
            if(cliente.getId() == id){
                Restaurant_Manager.clientes.remove(cliente);
                buscador = false;
                break;
            }
        }
        if(buscador){
            System.out.println("\t***   No se encontro el Cliente  ***");
        }else{
            Consola.InsertNewLog(User, "Elimino el cliente con el Id: '"+id+"'");
        }
    }
    
    public static void EliminarFactura(String User) {
        boolean buscador = true;
        int id = Consola.inputInt("\tIngrese el Id de la factura a eliminar\n\t-->");
        for (Factura factura : Restaurant_Manager.facturas) {
            if(factura.getClient()== id){
                Restaurant_Manager.facturas.remove(factura);
                buscador = false;
                break;
            }
        }
        if(buscador){
            System.out.println("\t***   No se encontro la Factura  ***");
        }else{
            Consola.InsertNewLog(User, "Elimino La factura con el Id: '"+id+"'");
        }
    }
    
}
