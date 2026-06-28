package com.concursopublicoapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inscricoes")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidato_id")
    private Candidato candidato;
    @ManyToOne
    @JoinColumn(name = "concurso_id")
    private Concurso concurso;
    @Column(nullable = false)
    private String cargo;
    private java.time.LocalDateTime dataInscricao;
    private Boolean taxaPaga;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Candidato getCandidato() { return candidato; }
    public void setCandidato(Candidato candidato) { this.candidato = candidato; }
    public Concurso getConcurso() { return concurso; }
    public void setConcurso(Concurso concurso) { this.concurso = concurso; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public java.time.LocalDateTime getDataInscricao() { return dataInscricao; }
    public void setDataInscricao(java.time.LocalDateTime dataInscricao) { this.dataInscricao = dataInscricao; }
    public Boolean getTaxaPaga() { return taxaPaga; }
    public void setTaxaPaga(Boolean taxaPaga) { this.taxaPaga = taxaPaga; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
