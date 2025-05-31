package br.sistemadoacoes.bo;

import br.sistemadoacoes.dto.OngDTO;
import br.sistemadoacoes.exception.RecursoNaoEncontradoException;
import br.sistemadoacoes.model.Ong;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OngBO {

    public Ong buscarPorId(Long id) {
        Ong ong = Ong.findById(id);
        if (ong == null) {
            throw new RecursoNaoEncontradoException("ONG não encontrada com ID: " + id);
        }
        return ong;
    }

    public Ong criar(OngDTO dto) {
        Ong existente = Ong.find("cnpj", dto.cnpj).firstResult();
        if (existente != null) {
            throw new RecursoNaoEncontradoException("Já existe uma ONG cadastrada com este CNPJ.");
        }

        Ong ong = new Ong();
        ong.nome = dto.nome;
        ong.email = dto.email;
        ong.telefone = dto.telefone;
        ong.site = dto.site;
        ong.endereco = dto.endereco;
        ong.cnpj = dto.cnpj;
        ong.missao = dto.missao;
        ong.categoria = dto.categoria;
        ong.persist();
        return ong;
    }
}
