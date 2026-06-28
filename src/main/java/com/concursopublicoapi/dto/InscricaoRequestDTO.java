package com.concursopublicoapi.dto;

import jakarta.validation.constraints.*;

public class InscricaoRequestDTO {

    @NotNull(message = "CandidatoId é obrigatório")
    @Positive(message = "CandidatoId deve ser um ID válido (positivo)")
    private Long candidatoId;
    @NotNull(message = "ConcursoId é obrigatório")
    @Positive(message = "ConcursoId deve ser um ID válido (positivo)")
    private Long concursoId;
    @NotBlank(message = "cargo não pode estar em branco")
    private String cargo;
    @NotNull(message = "data inscricao não pode ser nulo")
    private java.time.LocalDateTime dataInscricao;
    @NotNull(message = "taxa paga não pode ser nulo")
    private Boolean taxaPaga;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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
