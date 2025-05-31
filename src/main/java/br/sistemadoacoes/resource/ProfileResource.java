package br.sistemadoacoes.resource;

import br.sistemadoacoes.bo.DoacaoBO;
import br.sistemadoacoes.bo.UsuarioBO;
import br.sistemadoacoes.dto.DoacaoDTO;
import br.sistemadoacoes.model.Doacao;
import br.sistemadoacoes.model.Usuario;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/profile")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

    @Inject
    UsuarioBO usuarioBO;

    @Inject
    DoacaoBO doacaoBO;

    @GET
    public Response obterPerfil(@QueryParam("email") String email) {
        Usuario usuario = usuarioBO.buscarPorEmail(email);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado").build();
        }

        List<Doacao> doacoes = doacaoBO.buscarPorUsuario(usuario.id);
        double totalValor = doacoes.stream().mapToDouble(d -> d.valor != null ? d.valor : 0.0).sum();

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("usuario", usuario);
        resposta.put("doacoes", doacoes);
        resposta.put("totalDoacoes", doacoes.size());
        resposta.put("totalValor", totalValor);

        return Response.ok(resposta).build();
    }
}
