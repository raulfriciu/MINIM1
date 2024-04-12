package edu.upc.dsa;

import edu.upc.dsa.models.Piloto;

import java.util.List;

public interface PilotosManager {


    public Piloto addPiloto(String name, String apellido);
    public Piloto addPiloto(Piloto p);
    public Piloto getPiloto(String id);
    public List<Piloto> findAll();
    public void deletePiloto(String id);
    public Piloto updatePiloto(Piloto p);

    public int size();
}
