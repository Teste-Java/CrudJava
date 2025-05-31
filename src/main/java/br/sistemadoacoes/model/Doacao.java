package br.sistemadoacoes.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "DOACOES")
public class Doacao extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    public Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ONG_ID", nullable = false)
    public Ong ong;

    @Column(name = "TIPO_DOACAO")
    public String tipoDoacao;

    @Column(name = "VALOR")
    public Double valor;

    @Column(name = "DATA_DOACAO")
    public Date dataDoacao;
}
