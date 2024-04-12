package edu.upc.dsa.services;


import edu.upc.dsa.DronesManager;
import edu.upc.dsa.DronesManagerImpl;
import edu.upc.dsa.models.Dron;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/drones", description = "Endpoint to Dron Service")
@Path("/drones")
public class DronesService {

    private DronesManager dm;

    public DronesService() {
        this.dm = DronesManagerImpl.getInstance();
        if (dm.size()==0) {
            this.dm.addDron("Tiburon", "Seat", "Ibiza");
            this.dm.addDron("Mono", "Dacia", "Duster");
            this.dm.addDron("Toro", "Skoda", "Fabia");
        }


    }

    @GET
    @ApiOperation(value = "get all Dron", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Dron.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrones() {

        List<Dron> drons = this.dm.findAll();

        GenericEntity<List<Dron>> entity = new GenericEntity<List<Dron>>(drons) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Dron", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Dron.class),
            @ApiResponse(code = 404, message = "Dron not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDron(@PathParam("id") String id) {
        Dron t = this.dm.getDron(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Dron", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Dron not found")
    })
    @Path("/{id}")
    public Response deleteDron(@PathParam("id") String id) {
        Dron t = this.dm.getDron(id);
        if (t == null) return Response.status(404).build();
        else this.dm.deleteDron(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Dron", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Dron not found")
    })
    @Path("/")
    public Response updateDron(Dron dron) {

        Dron t = this.dm.updateDron(dron);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Dron", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Dron.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newDron(Dron dron) {

        if (dron.getFabricante()==null || dron.getName()==null || dron.getModelo()==null)  return Response.status(500).entity(dron).build();
        this.dm.addDron(dron);
        return Response.status(201).entity(dron).build();
    }

}