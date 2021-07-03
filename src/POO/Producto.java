package POO;

import java.io.Serializable;
import java.util.ArrayList;

public class Producto implements Serializable{
    private int id;
    private String name;
    private String description;
    private float cost;
    private float price;
    private ArrayList<Ingrediente> ingredients;

    public Producto() {
    }

    public Producto(String name, float price) {
        this.name = name;
        this.price = price;
    }
    
    public Producto(int id, String name, String description, float cost, float price, ArrayList<Ingrediente> ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.price = price;
        this.ingredients = ingredients;
    }

    public Object [] toVector(){
        Object obj[] = {this.name, this.price};
        return obj;
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

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredients;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredients) {
        this.ingredients = ingredients;
    }
     
    @Override
    public String toString(){
        return this.name;
    }
    
}
