package com.concursopublicoapi.dto;

import jakarta.validation.constraints.*;

public class ConcursoRequestDTO {

    @NotBlank(message = "titulo não pode estar em branco")
    private String titulo;
    @NotBlank(message = "orgao não pode estar em branco")
    private String orgao;
    @Min(value = 0, message = "vagas não pode ser negativo")
    @NotNull(message = "vagas não pode ser nulo")
    private Integer vagas;
    @NotNull(message = "data abertura não pode ser nulo")
    private java.time.LocalDateTime dataAbertura;
    @NotNull(message = "data encerramento não pode ser nulo")
    private java.time.LocalDateTime dataEncerramento;
    @NotBlank(message = "edital não pode estar em branco")
    private String edital;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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
