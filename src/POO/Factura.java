package POO;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable{
    private int id;
    private int client;
    private String date;
    private ArrayList<Producto> products;

    public Factura(int id, int client, String date, ArrayList<Producto> products) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.products = products;
    }
    
    public Object[] toVector(){
        Object obj[] = {this.id, this.client, this.date, this.products};
        return obj;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
