package com.ejemplo.jakarta_postgres_app;



import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/saludo")
public class SaludoResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String saludar() {
        return "¡Hola Justin!";
    }
}
