package com.concursopublicoapi.service;

import com.concursopublicoapi.dto.CandidatoRequestDTO;
import com.concursopublicoapi.dto.CandidatoResponseDTO;
import com.concursopublicoapi.exception.ResourceNotFoundException;
import com.concursopublicoapi.mapper.CandidatoMapper;
import com.concursopublicoapi.model.Candidato;
import com.concursopublicoapi.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CandidatoService {

    @Autowired
    private CandidatoRepository repository;

    @Autowired
    private CandidatoMapper mapper;

    @Transactional(readOnly = true)
    public List<CandidatoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CandidatoResponseDTO buscar(Long id) {
        Candidato entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Candidato não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public CandidatoResponseDTO criar(CandidatoRequestDTO dto) {
        Candidato entity = mapper.toEntity(dto);
        Candidato salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public CandidatoResponseDTO atualizar(Long id, CandidatoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Candidato não encontrado com id: " + id);
        }
        Candidato entity = mapper.toEntity(dto);
        entity.setId(id);
        Candidato salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Candidato não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
