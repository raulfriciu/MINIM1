package edu.upc.dsa;

import edu.upc.dsa.util.RandomUtils;

public class PlanVuelo {

    public String getDron() {
        return dron;
    }

    public void setDron(String dron) {
        this.dron = dron;
    }

    public double getDia() {
        return dia;
    }

    public void setDia(double dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public double getLat_origen() {
        return lat_origen;
    }

    public void setLat_origen(double lat_origen) {
        this.lat_origen = lat_origen;
    }

    public double getLong_origen() {
        return long_origen;
    }

    public void setLong_origen(double long_origen) {
        this.long_origen = long_origen;
    }

    public double getLat_dest() {
        return lat_dest;
    }

    public void setLat_dest(double lat_dest) {
        this.lat_dest = lat_dest;
    }

    public double getLong_dest() {
        return long_dest;
    }

    public void setLong_dest(double long_dest) {
        this.long_dest = long_dest;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    String dron;
    double dia;
    int hora;
    double lat_origen;
    double long_origen;
    double lat_dest;
    double long_dest;
    String piloto;


    public PlanVuelo(String dron, double dia, int hora, double lat_origen, double long_origen, double lat_dest, double long_dest, String piloto) {
        this.setDron(dron);
        this.setDia(dia);
        this.setHora(hora);
        this.setLat_origen(lat_origen);
        this.setLong_origen(long_origen);
        this.setLat_dest(lat_dest);
        this.setLong_dest(long_dest);
        this.setPiloto(piloto);
    }


    @Override
    public String toString() {
        return "Plan de vuelo [Dron="+dron+", dia=" + dia + ", hora=" + hora + ", Lat_origen=" + lat_origen + ", Long_origen=" + long_origen + ", Lat_dest=" + lat_dest + ", Long_dest=" + long_dest + ", Piloto=" + piloto + "]";
    }

}
