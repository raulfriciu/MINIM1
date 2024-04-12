package edu.upc.dsa.services;


import edu.upc.dsa.PilotosManager;
import edu.upc.dsa.PilotosManagerImpl;
import edu.upc.dsa.models.Piloto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/pilotos", description = "Endpoint to Piloto Service")
@Path("/pilotos")
public class PilotosService {

    private PilotosManager pm;

    public PilotosService() {
        this.pm = PilotosManagerImpl.getInstance();
        if (pm.size()==0) {
            this.pm.addPiloto("Juan", "Lopez");
            this.pm.addPiloto("Manolo", "Caro");
            this.pm.addPiloto("Jose", "Baez");
        }


    }

    @GET
    @ApiOperation(value = "get all Piloto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Piloto.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPilotos() {

        List<Piloto> pilotos = this.pm.findAll();

        GenericEntity<List<Piloto>> entity = new GenericEntity<List<Piloto>>(pilotos) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Piloto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Piloto.class),
            @ApiResponse(code = 404, message = "Piloto not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPiloto(@PathParam("id") String id) {
        Piloto p = this.pm.getPiloto(id);
        if (p == null) return Response.status(404).build();
        else  return Response.status(201).entity(p).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Piloto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Piloto not found")
    })
    @Path("/{id}")
    public Response deletePiloto(@PathParam("id") String id) {
        Piloto p = this.pm.getPiloto(id);
        if (p == null) return Response.status(404).build();
        else this.pm.deletePiloto(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Piloto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Piloto not found")
    })
    @Path("/")
    public Response updatePiloto(Piloto piloto) {

        Piloto p = this.pm.updatePiloto(piloto);

        if (p == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Piloto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Piloto.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPiloto(Piloto piloto) {

        if (piloto.getApellido()==null || piloto.getName()==null)  return Response.status(500).entity(piloto).build();
        this.pm.addPiloto(piloto);
        return Response.status(201).entity(piloto).build();
    }

}