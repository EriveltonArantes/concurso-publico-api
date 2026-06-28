package com.concursopublicoapi.dto;

public class ConcursoResponseDTO {

    private Long id;
    private String titulo;
    private String orgao;
    private Integer vagas;
    private java.time.LocalDateTime dataAbertura;
    private java.time.LocalDateTime dataEncerramento;
    private String edital;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getOrgao() { return orgao; }
    public void setOrgao(String orgao) { this.orgao = orgao; }
    public Integer getVagas() { return vagas; }
    public void setVagas(Integer vagas) { this.vagas = vagas; }
    public java.time.LocalDateTime getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(java.time.LocalDateTime dataAbertura) { this.dataAbertura = dataAbertura; }
    public java.time.LocalDateTime getDataEncerramento() { return dataEncerramento; }
    public void setDataEncerramento(java.time.LocalDateTime dataEncerramento) { this.dataEncerramento = dataEncerramento; }
    public String getEdital() { return edital; }
    public void setEdital(String edital) { this.edital = edital; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
