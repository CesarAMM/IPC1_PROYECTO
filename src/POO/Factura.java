package POO;

import java.io.Serializable;

public class Factura implements Serializable{
    private int client;
    private String date;
    private Producto products[];

    public Factura(int client, String date, Producto[] products) {
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

    public Producto[] getProducts() {
        return products;
    }

    public void setProducts(Producto[] products) {
        this.products = products;
    }
    
    
}
