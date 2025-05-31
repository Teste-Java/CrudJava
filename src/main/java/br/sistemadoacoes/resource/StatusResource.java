package br.sistemadoacoes.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class StatusResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String status() {
        return "🚀 API Doações de Inverno está ONLINE!";
    }
}
