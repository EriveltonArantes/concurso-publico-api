package com.concursopublicoapi.service;

import com.concursopublicoapi.dto.InscricaoRequestDTO;
import com.concursopublicoapi.dto.InscricaoResponseDTO;
import com.concursopublicoapi.exception.ResourceNotFoundException;
import com.concursopublicoapi.mapper.InscricaoMapper;
import com.concursopublicoapi.model.Inscricao;
import com.concursopublicoapi.repository.InscricaoRepository;
import com.concursopublicoapi.repository.CandidatoRepository;
import com.concursopublicoapi.model.Candidato;
import com.concursopublicoapi.repository.ConcursoRepository;
import com.concursopublicoapi.model.Concurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InscricaoService {

    @Autowired
    private InscricaoRepository repository;

    @Autowired
    private InscricaoMapper mapper;

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private ConcursoRepository concursoRepository;

    @Transactional(readOnly = true)
    public List<InscricaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public InscricaoResponseDTO buscar(Long id) {
        Inscricao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Inscricao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public InscricaoResponseDTO criar(InscricaoRequestDTO dto) {
        Inscricao entity = mapper.toEntity(dto);
        Candidato candidato = candidatoRepository.findById(dto.getCandidatoId())
            .orElseThrow(() -> new ResourceNotFoundException("Candidato não encontrado com id: " + dto.getCandidatoId()));
        entity.setCandidato(candidato);
        Concurso concurso = concursoRepository.findById(dto.getConcursoId())
            .orElseThrow(() -> new ResourceNotFoundException("Concurso não encontrado com id: " + dto.getConcursoId()));
        entity.setConcurso(concurso);
        Inscricao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public InscricaoResponseDTO atualizar(Long id, InscricaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Inscricao não encontrado com id: " + id);
        }
        Inscricao entity = mapper.toEntity(dto);
        entity.setId(id);
        Candidato candidato = candidatoRepository.findById(dto.getCandidatoId())
            .orElseThrow(() -> new ResourceNotFoundException("Candidato não encontrado com id: " + dto.getCandidatoId()));
        entity.setCandidato(candidato);
        Concurso concurso = concursoRepository.findById(dto.getConcursoId())
            .orElseThrow(() -> new ResourceNotFoundException("Concurso não encontrado com id: " + dto.getConcursoId()));
        entity.setConcurso(concurso);
        Inscricao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Inscricao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
