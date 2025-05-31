package br.sistemadoacoes.bo;

import br.sistemadoacoes.dto.UsuarioDTO;
import br.sistemadoacoes.exception.RecursoNaoEncontradoException;
import br.sistemadoacoes.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Date;

@ApplicationScoped
public class UsuarioBO {

    public Usuario autenticar(String email, String senha) {
        Usuario usuario = Usuario.find("email = ?1 AND senha = ?2", email, senha).firstResult();
        if (usuario == null) {
            throw new RecursoNaoEncontradoException("Email ou senha inválidos");
        }
        return usuario;
    }

    public Usuario buscarPorId(Long id) {
        Usuario usuario = Usuario.findById(id);
        if (usuario == null) {
            throw new RecursoNaoEncontradoException("Usuário não encontrado com ID: " + id);
        }
        return usuario;
    }

    public Usuario buscarPorEmail(String email) {
        Usuario usuario = Usuario.find("email", email).firstResult();
        if (usuario == null) {
            throw new RecursoNaoEncontradoException("Usuário não encontrado com email: " + email);
        }
        return usuario;
    }

    public Usuario criar(UsuarioDTO dto) {
        // Verifica se o e-mail já está em uso
        Usuario existente = Usuario.find("email", dto.email).firstResult();
        if (existente != null) {
            throw new RecursoNaoEncontradoException("Email já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.nome = dto.nome;
        usuario.email = dto.email;
        usuario.senha = dto.senha;
        usuario.tipo = dto.tipo;
        usuario.telefone = dto.telefone;
        usuario.dataCadastro = new Date(System.currentTimeMillis());

        usuario.persist();
        return usuario;
    }

    public Usuario atualizar(UsuarioDTO dto) {
        Usuario usuario = Usuario.find("email = ?1 AND senha = ?2", dto.email, dto.senha).firstResult();
        if (usuario == null) {
            throw new RecursoNaoEncontradoException("Usuário não encontrado para atualização");
        }

        if (dto.novaSenha != null && !dto.novaSenha.isEmpty()) {
            usuario.senha = dto.novaSenha;
        }

        if (dto.telefone != null) {
            usuario.telefone = dto.telefone;
        }

        if (dto.nome != null) {
            usuario.nome = dto.nome;
        }

        usuario.persist();
        return usuario;
    }

    public void deletarPorEmailESenha(String email, String senha) {
        Usuario usuario = Usuario.find("email = ?1 AND senha = ?2", email, senha).firstResult();
        if (usuario == null) {
            throw new RecursoNaoEncontradoException("Usuário não encontrado para exclusão");
        }
        usuario.delete();
    }
}
