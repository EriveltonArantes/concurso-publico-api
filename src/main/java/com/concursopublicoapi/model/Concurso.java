package com.concursopublicoapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "concursos")
public class Concurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String orgao;
    private Integer vagas;
    private java.time.LocalDateTime dataAbertura;
    private java.time.LocalDateTime dataEncerramento;
    @Column(nullable = false)
    private String edital;
    @Column(nullable = false)
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
