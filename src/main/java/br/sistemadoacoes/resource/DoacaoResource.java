package br.sistemadoacoes.resource;

import br.sistemadoacoes.bo.DoacaoBO;
import br.sistemadoacoes.dto.DoacaoDTO;
import br.sistemadoacoes.model.Doacao;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoacaoResource {

    @Inject
    DoacaoBO doacaoBO;

    // POST /help-center
    @POST
    @Path("/help-center")
    @Transactional
    public Response realizarDoacao(DoacaoDTO dto) {
        Doacao doacao = doacaoBO.realizarDoacao(dto);
        return Response.status(Response.Status.CREATED).entity(doacao).build();
    }


}
