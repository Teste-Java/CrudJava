package br.sistemadoacoes.dto;

public class DoacaoDTO {

    public String tipoDoacao;
    public Double valor;
    public Long usuarioId;
    public Long ongId;

    public DoacaoDTO() {}

    public DoacaoDTO(String tipoDoacao, Double valor, Long usuarioId, Long ongId) {
        this.tipoDoacao = tipoDoacao;
        this.valor = valor;
        this.usuarioId = usuarioId;
        this.ongId = ongId;
    }
}
