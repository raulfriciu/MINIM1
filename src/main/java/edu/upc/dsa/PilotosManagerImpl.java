package edu.upc.dsa;

import edu.upc.dsa.models.Piloto;

import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class PilotosManagerImpl implements PilotosManager {
    private static PilotosManager instance;
    protected List<Piloto> pilotos;
    final static Logger logger = Logger.getLogger(PilotosManagerImpl.class);

    private PilotosManagerImpl() {
        this.pilotos = new LinkedList<>();
    }

    public static PilotosManager getInstance() {
        if (instance==null) instance = new PilotosManagerImpl();
        return instance;
    }

    public int size() {
        int ret = this.pilotos.size();
        logger.info("size " + ret);

        return ret;
    }

    public Piloto addPiloto(Piloto p) {
        logger.info("new Piloto " + p);

        this.pilotos.add (p);
        logger.info("new Piloto added");
        return p;
    }

    public Piloto addPiloto(String name, String apellido) {
        return this.addPiloto(new Piloto(name, apellido));
    }

    public Piloto getPiloto(String id) {
        logger.info("getPiloto("+id+")");

        for (Piloto p: this.pilotos) {
            if (p.getId().equals(id)) {
                logger.info("getPiloto("+id+"): "+p);

                return p;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Piloto> findAll() {
        return this.pilotos;
    }

    @Override
    public void deletePiloto(String id) {

        Piloto p = this.getPiloto(id);
        if (p==null) {
            logger.warn("not found " + p);
        }
        else logger.info(p+" deleted ");

        this.pilotos.remove(p);

    }

    @Override
    public Piloto updatePiloto(Piloto p) {
        Piloto q = this.getPiloto(p.getId());

        if (q!=null) {
            logger.info(p +" rebut!!!! ");

            q.setApellido(p.getApellido());
            q.setName(p.getName());

            logger.info(q+" updated ");
        }
        else {
            logger.warn("not found "+ p);
        }

        return q;
    }
}