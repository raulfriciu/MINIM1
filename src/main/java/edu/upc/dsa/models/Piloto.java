package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Piloto {

    String id;
    String name;
    String apellido;
    static int lastId;

    public Piloto(String name, String apellido) {
        this.id = RandomUtils.getId();
    }

    public Piloto(String name, String apellido, String modelo) {
        this(name, apellido);
        this.setApellido(apellido);
        this.setName(name);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id=id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Dron [id="+id+", name=" + name + ", fabricante=" + apellido + "]";
    }

}