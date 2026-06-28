package com.concursopublicoapi.dto;

import jakarta.validation.constraints.*;

public class ResultadoRequestDTO {

    @NotNull(message = "InscricaoId é obrigatório")
    @Positive(message = "InscricaoId deve ser um ID válido (positivo)")
    private Long inscricaoId;
    @NotNull(message = "nota objetiva não pode ser nulo")
    private Double notaObjetiva;
    @NotNull(message = "nota redacao não pode ser nulo")
    private Double notaRedacao;
    @NotNull(message = "nota pratica não pode ser nulo")
    private Double notaPratica;
    @NotNull(message = "classificacao não pode ser nulo")
    private Integer classificacao;
    @NotNull(message = "aprovado não pode ser nulo")
    private Boolean aprovado;

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
