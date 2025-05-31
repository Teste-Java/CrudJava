package br.sistemadoacoes.resource;

import br.sistemadoacoes.bo.UsuarioBO;
import br.sistemadoacoes.dto.UsuarioDTO;
import br.sistemadoacoes.model.Usuario;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioBO usuarioBO;

    @POST
    @Path("/register")
    @Transactional
    public Response criarUsuario(UsuarioDTO dto) {
        Usuario usuario = usuarioBO.criar(dto);
        return Response.status(Response.Status.CREATED).entity(usuario).build();
    }

    @POST
    @Path("/login")
    public Response login(UsuarioDTO dto) {
        Usuario usuario = usuarioBO.autenticar(dto.email, dto.senha);
        return Response.ok(usuario).build();
    }

    @PUT
    @Path("/update")
    @Transactional
    public Response atualizarUsuario(UsuarioDTO dto) {
        Usuario atualizado = usuarioBO.atualizar(dto);
        return Response.ok(atualizado).build();
    }

    @DELETE
    @Path("/update")
    @Transactional
    public Response deletarUsuario(UsuarioDTO dto) {
        usuarioBO.deletarPorEmailESenha(dto.email, dto.senha);
        return Response.noContent().build();
    }
}
