package com.concursopublicoapi.repository;

import com.concursopublicoapi.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
