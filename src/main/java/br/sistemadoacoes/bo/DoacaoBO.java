package br.sistemadoacoes.bo;

import br.sistemadoacoes.dto.DoacaoDTO;
import br.sistemadoacoes.model.Doacao;
import br.sistemadoacoes.model.Ong;
import br.sistemadoacoes.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.sql.Date;
import java.util.List;

@ApplicationScoped
public class DoacaoBO {

    @Inject
    UsuarioBO usuarioBO;

    @Inject
    OngBO ongBO;

    @Transactional
    public Doacao realizarDoacao(DoacaoDTO dto) {
        Usuario usuario = usuarioBO.buscarPorId(dto.usuarioId);
        Ong ong = ongBO.buscarPorId(dto.ongId);

        Doacao doacao = new Doacao();
        doacao.tipoDoacao = dto.tipoDoacao;
        doacao.valor = dto.valor;
        doacao.usuario = usuario;
        doacao.ong = ong;
        doacao.dataDoacao = new Date(System.currentTimeMillis());
        doacao.persist();

        return doacao;
    }

    public List<Doacao> buscarPorUsuario(Long usuarioId) {
        return Doacao.find("usuario.id", usuarioId).list();
    }
}
