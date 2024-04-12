package edu.upc.dsa;

import edu.upc.dsa.models.Dron;

import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class DronesManagerImpl implements DronesManager {
    private static DronesManager instance;
    protected List<Dron> drons;
    final static Logger logger = Logger.getLogger(DronesManagerImpl.class);

    private DronesManagerImpl() {
        this.drons = new LinkedList<>();
    }

    public static DronesManager getInstance() {
        if (instance==null) instance = new DronesManagerImpl();
        return instance;
    }

    public int size() {
        int ret = this.drons.size();
        logger.info("size " + ret);

        return ret;
    }

    public Dron addDron(Dron d) {
        logger.info("new Dron " + d);

        this.drons.add (d);
        logger.info("new Dron added");
        return d;
    }

    public Dron addDron(String name, String fabricante, String modelo) {
        return this.addDron(new Dron(name, fabricante, modelo));
    }

    public Dron getDron(String id) {
        logger.info("getDron("+id+")");

        for (Dron t: this.drons) {
            if (t.getId().equals(id)) {
                logger.info("getDron("+id+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Dron> findAll() {
        return this.drons;
    }

    @Override
    public void deleteDron(String id) {

        Dron t = this.getDron(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.drons.remove(t);

    }

    @Override
    public Dron updateDron(Dron d) {
        Dron t = this.getDron(d.getId());

        if (t!=null) {
            logger.info(d +" rebut!!!! ");

            t.setFabricante(d.getFabricante());
            t.setName(d.getName());
            t.setModelo(d.getModelo());

            logger.info(t+" updated ");
        }
        else {
            logger.warn("not found "+ d);
        }

        return t;
    }
}