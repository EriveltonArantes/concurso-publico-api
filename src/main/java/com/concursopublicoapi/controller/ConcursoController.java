package com.concursopublicoapi.controller;

import com.concursopublicoapi.dto.ConcursoRequestDTO;
import com.concursopublicoapi.dto.ConcursoResponseDTO;
import com.concursopublicoapi.service.ConcursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Concurso", description = "Gerenciamento de concursos")
@RestController
@RequestMapping("/api/concursos")
public class ConcursoController {

    @Autowired
    private ConcursoService service;

    @Operation(summary = "Listar todos os Concurso")
    @GetMapping
    public List<ConcursoResponseDTO> listar(@RequestParam(required = false) String titulo) {
        List<ConcursoResponseDTO> resultado = service.listar();
        if (titulo != null && !titulo.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getTitulo() != null &&
                item.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Concurso por ID")
    @GetMapping("/{id}")
    public ConcursoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Concurso")
    @PostMapping
    public ResponseEntity<ConcursoResponseDTO> criar(@Valid @RequestBody ConcursoRequestDTO concurso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(concurso));
    }

    @Operation(summary = "Atualizar Concurso")
    @PutMapping("/{id}")
    public ConcursoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ConcursoRequestDTO concurso) {
        return service.atualizar(id, concurso);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Concurso")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
