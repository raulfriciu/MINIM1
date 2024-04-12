package edu.upc.dsa;

import edu.upc.dsa.models.Dron;

import java.util.List;

public interface DronesManager {


    public Dron addDron(String name, String fabricante, String modelo);
    public Dron addDron(Dron d);
    public Dron getDron(String id);
    public List<Dron> findAll();
    public void deleteDron(String id);
    public Dron updateDron(Dron d);

    public int size();
}
