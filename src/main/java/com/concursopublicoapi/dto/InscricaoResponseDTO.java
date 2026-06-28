package com.concursopublicoapi.dto;

public class InscricaoResponseDTO {

    private Long id;
    private Long candidatoId;
    private Long concursoId;
    private String cargo;
    private java.time.LocalDateTime dataInscricao;
    private Boolean taxaPaga;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCandidatoId() { return candidatoId; }
    public void setCandidatoId(Long candidatoId) { this.candidatoId = candidatoId; }
    public Long getConcursoId() { return concursoId; }
    public void setConcursoId(Long concursoId) { this.concursoId = concursoId; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public java.time.LocalDateTime getDataInscricao() { return dataInscricao; }
    public void setDataInscricao(java.time.LocalDateTime dataInscricao) { this.dataInscricao = dataInscricao; }
    public Boolean getTaxaPaga() { return taxaPaga; }
    public void setTaxaPaga(Boolean taxaPaga) { this.taxaPaga = taxaPaga; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
