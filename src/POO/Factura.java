package POO;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable{
    private int client;
    private String date;
    private ArrayList<Producto> products;

    public Factura(int client, String date, ArrayList<Producto> products) {
        this.client = client;
        this.date = date;
        this.products = products;
    }
    

    public Factura() {
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Producto> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Producto> products) {
        this.products = products;
    }
    
    @Override
    public String toString(){
        return "IdCliente: " + this.client + "\t\t Fecha: " + this.date +"\n";
    }
}
