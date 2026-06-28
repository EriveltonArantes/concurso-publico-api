package com.concursopublicoapi.repository;

import com.concursopublicoapi.model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
}
