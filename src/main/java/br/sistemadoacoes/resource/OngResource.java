package br.sistemadoacoes.resource;

import br.sistemadoacoes.bo.OngBO;
import br.sistemadoacoes.dto.OngDTO;
import br.sistemadoacoes.exception.RecursoNaoEncontradoException;
import br.sistemadoacoes.model.Doacao;
import br.sistemadoacoes.model.Ong;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/ong") // agora a rota base é /ong
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OngResource {

    @Inject
    OngBO ongBO;

    @POST
    @Path("/register")
    @Transactional
    public Response criarOng(OngDTO dto) {
        Ong ong = ongBO.criar(dto);
        return Response.status(Response.Status.CREATED).entity(ong).build();
    }

    @GET
    public Response listarOngs() {
        List<Ong> ongs = Ong.listAll();
        return Response.ok(ongs).build();
    }

    @GET
    @Path("/{id}/doacoes")
    public Response listarDoacoesRecebidas(@PathParam("id") Long id) {
        Ong ong = ongBO.buscarPorId(id);
        if (ong == null) {
            throw new RecursoNaoEncontradoException("ONG não encontrada");
        }
        List<Doacao> doacoes = Doacao.find("ong.id", ong.id).list();
        return Response.ok(doacoes).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Ong ong = ongBO.buscarPorId(id);
        if (ong == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(ong).build();
    }
}
