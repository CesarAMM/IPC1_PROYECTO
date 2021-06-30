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
            CargaDatos_Bin();
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
    
    private static void CargaDatos_Bin(){
        String paht =  "PruebasProyecto\\Bin\\";
        Restaurant_Manager.usuarios = (ArrayList<Usuario>) Consola.deserialize(paht+ "users.ipcrm");
        Restaurant_Manager.clientes = (ArrayList<Cliente>) Consola.deserialize(paht+ "clients.ipcrm");
        Restaurant_Manager.productos = (ArrayList<Producto>) Consola.deserialize(paht+ "products.ipcrm");
        Restaurant_Manager.facturas = (ArrayList<Factura>) Consola.deserialize(paht+ "invoices.ipcrm");
    }
    
    public static void Listar(ArrayList objeto){
        for (Object object : objeto) {
            System.out.print(object.toString());
        }
    }
    
    public static void MostrarUsuario(String user){
        boolean buscador = true;
        String usuariodelete = Consola.inputString("\tIngrese el Usuari\n\t-->");
        for (Usuario usuario : Restaurant_Manager.usuarios) {
            if(usuario.getUsername().equals(usuariodelete)){
                System.out.println(usuario.toString());
                buscador = false;
                break;
            }
        }
        if(buscador == true){
            System.out.println("***   El usuario '"+ usuariodelete+"' no existe.   ***");
            Consola.InsertNewLog(user, "El usuario '"+ usuariodelete+"' no existe.");
        }
    }
    
    public static void MostrarProductos(String user){
        boolean buscador = true;
        int id = Consola.inputInt("\tIngrese el Id\n\t-->");
        for (Producto producto : Restaurant_Manager.productos) {
            if(producto.getId() == id){
                System.out.println(producto.toString());
                buscador = false;
                break;
            }
        }
        if(buscador){
            System.out.println("\t***   No se encontro el Producto  ***");
            Consola.InsertNewLog(user, "No se encontro el Producto con el Id: " + id);
        }
    }
    
    public static void MostrarCliente(String user){
        boolean buscador = true;
        int id = Consola.inputInt("\tIngrese el Id del producto\n\t-->");
        for (Cliente cliente : Restaurant_Manager.clientes) {
            if(cliente.getId() == id){
                System.out.println(cliente.toString());
                buscador = false;
                break;
            }
        }
        if(buscador){
            System.out.println("\t***   No se encontro el Cliente  ***");
            Consola.InsertNewLog(user, "No se encontro el Cliente con el Id: " + id);
        }
    }
    
    public static void MostrarFactura(String User) {
        boolean buscador = true;
        int id = Consola.inputInt("\tIngrese el Id de la factura a eliminar\n\t-->");
        for (Factura factura : Restaurant_Manager.facturas) {
            if(factura.getClient()== id){
                factura.toString();
                buscador = false;
                break;
            }
        }
        if(buscador){
            System.out.println("\t***   No se encontro la Factura  ***");
            Consola.InsertNewLog(User, "No encontro La factura con el Id: '"+id+"'");
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
    
    public static void SerealizarDatos(){
        String paht =  "PruebasProyecto\\Bin\\";
        Consola.serialize(paht + "users.ipcrm", Restaurant_Manager.usuarios);
        Consola.serialize(paht + "clients.ipcrm", Restaurant_Manager.clientes);
        Consola.serialize(paht + "products.ipcrm", Restaurant_Manager.productos);
        Consola.serialize(paht + "invoices.ipcrm", Restaurant_Manager.facturas);
    }

    public static void JsonDatos(int i) {
        Gson gson = new Gson();
        switch(i){
            case 1:
                String gson_store = gson.toJson(Restaurant_Manager.restaurante);
                Consola.writeFile(gson_store, "PruebasProyecto\\Json\\config.json");
                break;
            case 2:
                String gson_usuarios = gson.toJson(Restaurant_Manager.usuarios);
                Consola.writeFile(gson_usuarios,"PruebasProyecto\\Json\\users.json" );
                break;
            case 3:
                String gson_clientes = gson.toJson(Restaurant_Manager.clientes);
                Consola.writeFile(gson_clientes,"PruebasProyecto\\Json\\clients.json" );
                break;
            case 4:
                String gson_productos = gson.toJson(Restaurant_Manager.productos);
                Consola.writeFile(gson_productos,"PruebasProyecto\\Json\\products.json" );
                break;
            case 5:
                String gson_Facturas = gson.toJson(Restaurant_Manager.facturas);
                Consola.writeFile(gson_Facturas,"PruebasProyecto\\Json\\invoices.json" );
                break;
        }
    }
}
