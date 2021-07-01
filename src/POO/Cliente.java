package POO;

import java.io.Serializable;

public class Cliente implements Serializable{
    private int id;
    private String name;
    private String address;
    private int phone;
    private String nit;

    public Cliente() {
    }

    public Cliente(int id, String name, String address, int phone, String nit) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.nit = nit;
    }
    
    public Object[] getVector(){
        Object[] obj = {this.id, this.name, this.address, this.phone, this.nit};
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    @Override
    public String toString(){
        return "Id: " + this.id + "\tNombre: " + this.name +"\t\t Direccion: "+ this.address + "\t\t Nit: "+ this.nit +"\n";
    }
}
