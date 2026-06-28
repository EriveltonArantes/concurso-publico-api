package com.concursopublicoapi.dto;

public class ResultadoResponseDTO {

    private Long id;
    private Long inscricaoId;
    private Double notaObjetiva;
    private Double notaRedacao;
    private Double notaPratica;
    private Integer classificacao;
    private Boolean aprovado;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getInscricaoId() { return inscricaoId; }
    public void setInscricaoId(Long inscricaoId) { this.inscricaoId = inscricaoId; }
    public Double getNotaObjetiva() { return notaObjetiva; }
    public void setNotaObjetiva(Double notaObjetiva) { this.notaObjetiva = notaObjetiva; }
    public Double getNotaRedacao() { return notaRedacao; }
    public void setNotaRedacao(Double notaRedacao) { this.notaRedacao = notaRedacao; }
    public Double getNotaPratica() { return notaPratica; }
    public void setNotaPratica(Double notaPratica) { this.notaPratica = notaPratica; }
    public Integer getClassificacao() { return classificacao; }
    public void setClassificacao(Integer classificacao) { this.classificacao = classificacao; }
    public Boolean getAprovado() { return aprovado; }
    public void setAprovado(Boolean aprovado) { this.aprovado = aprovado; }
}
