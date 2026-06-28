package com.concursopublicoapi.repository;

import com.concursopublicoapi.model.Concurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcursoRepository extends JpaRepository<Concurso, Long> {
}
