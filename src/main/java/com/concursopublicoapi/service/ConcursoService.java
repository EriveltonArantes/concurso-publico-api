package com.concursopublicoapi.service;

import com.concursopublicoapi.dto.ConcursoRequestDTO;
import com.concursopublicoapi.dto.ConcursoResponseDTO;
import com.concursopublicoapi.exception.ResourceNotFoundException;
import com.concursopublicoapi.mapper.ConcursoMapper;
import com.concursopublicoapi.model.Concurso;
import com.concursopublicoapi.repository.ConcursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConcursoService {

    @Autowired
    private ConcursoRepository repository;

    @Autowired
    private ConcursoMapper mapper;

    @Transactional(readOnly = true)
    public List<ConcursoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ConcursoResponseDTO buscar(Long id) {
        Concurso entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Concurso não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ConcursoResponseDTO criar(ConcursoRequestDTO dto) {
        Concurso entity = mapper.toEntity(dto);
        Concurso salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ConcursoResponseDTO atualizar(Long id, ConcursoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Concurso não encontrado com id: " + id);
        }
        Concurso entity = mapper.toEntity(dto);
        entity.setId(id);
        Concurso salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Concurso não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
