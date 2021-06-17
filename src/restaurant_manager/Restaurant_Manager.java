package restaurant_manager;

import POO.*;
import java.util.ArrayList;

public class Restaurant_Manager {
    public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public ArrayList<Factura> facturas = new ArrayList<Factura>();
    public ArrayList<Producto> productos = new ArrayList<Producto>();
    public static void main(String[] args) {
        Cesar_Funciones.InitDownloadData();
    }
    
}
