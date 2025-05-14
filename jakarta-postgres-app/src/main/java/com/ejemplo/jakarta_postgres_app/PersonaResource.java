package com.ejemplo.jakarta_postgres_app;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/personas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonaResource {

    @Inject
    private PersonaService service;

    @GET
    public List<Persona> listar() {
        return service.listar();
    }

    @POST
    public Response crear(Persona persona) {
        Persona creada = service.guardar(persona);
        return Response.status(Response.Status.CREATED).entity(creada).build();
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") Long id, Persona persona) {
        persona.setId(id);
        Persona actualizada = service.actualizar(persona);
        return Response.ok(actualizada).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        service.eliminar(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response obtener(@PathParam("id") Long id) {
        Persona persona = service.obtener(id);
        if (persona != null) {
            return Response.ok(persona).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
