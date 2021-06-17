package POO;

import java.io.Serializable;

public class Producto implements Serializable{
    private int id;
    private String name;
    private String description;
    private float cost;
    private float price;
    private Ingrediente ingredientes[];

    public Producto() {
    }

    public Producto(String name, float price) {
        this.name = name;
        this.price = price;
    }
    
    public Producto(int id, String name, String description, float cost, float price, Ingrediente[] ingredientes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.price = price;
        this.ingredientes = ingredientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Ingrediente[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }
    
}
