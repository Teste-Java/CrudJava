package br.sistemadoacoes.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "USUARIOS")
public class Usuario extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long id;

    @Column(name = "NOME", nullable = false)
    public String nome;

    @Column(name = "EMAIL", nullable = false, unique = true)
    public String email;

    @Column(name = "SENHA", nullable = false)
    public String senha;

    @Column(name = "TIPO", nullable = false)
    public String tipo;

    @Column(name = "TELEFONE")
    public String telefone;

    @Column(name = "DATA_CADASTRO")
    public Date dataCadastro;
}
