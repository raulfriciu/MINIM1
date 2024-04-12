package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Dron {

    String id;
    String name;
    String fabricante;
    String modelo;
    static int lastId;

    public Dron() {
        this.id = RandomUtils.getId();
    }

    public Dron(String name, String fabricante, String modelo) {
        this();
        this.setFabricante(fabricante);
        this.setName(name);
        this.setModelo(modelo);
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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Dron [id="+id+", name=" + name + ", fabricante=" + fabricante + ", modelo=" + modelo + "]";
    }

}