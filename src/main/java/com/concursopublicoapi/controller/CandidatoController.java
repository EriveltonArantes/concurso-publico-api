package com.concursopublicoapi.controller;

import com.concursopublicoapi.dto.CandidatoRequestDTO;
import com.concursopublicoapi.dto.CandidatoResponseDTO;
import com.concursopublicoapi.service.CandidatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Candidato", description = "Gerenciamento de candidatos")
@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService service;

    @Operation(summary = "Listar todos os Candidato")
    @GetMapping
    public List<CandidatoResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<CandidatoResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Candidato por ID")
    @GetMapping("/{id}")
    public CandidatoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Candidato")
    @PostMapping
    public ResponseEntity<CandidatoResponseDTO> criar(@Valid @RequestBody CandidatoRequestDTO candidato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(candidato));
    }

    @Operation(summary = "Atualizar Candidato")
    @PutMapping("/{id}")
    public CandidatoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody CandidatoRequestDTO candidato) {
        return service.atualizar(id, candidato);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Candidato")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
