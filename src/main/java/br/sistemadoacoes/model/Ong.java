package br.sistemadoacoes.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "ONGS")
public class Ong extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long id;

    @Column(name = "NOME", nullable = false)
    public String nome;

    @Column(name = "EMAIL")
    public String email;

    @Column(name = "TELEFONE")
    public String telefone;

    @Column(name = "SITE")
    public String site;

    @Column(name = "ENDERECO")
    public String endereco;

    @Column(name = "CNPJ", nullable = false, unique = true)
    public String cnpj;

    @Column(name = "MISSAO")
    public String missao;

    @Column(name = "CATEGORIA")
    public String categoria;
}
