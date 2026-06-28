package com.concursopublicoapi.service;

import com.concursopublicoapi.dto.ResultadoRequestDTO;
import com.concursopublicoapi.dto.ResultadoResponseDTO;
import com.concursopublicoapi.exception.ResourceNotFoundException;
import com.concursopublicoapi.mapper.ResultadoMapper;
import com.concursopublicoapi.model.Resultado;
import com.concursopublicoapi.repository.ResultadoRepository;
import com.concursopublicoapi.repository.InscricaoRepository;
import com.concursopublicoapi.model.Inscricao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ResultadoService {

    @Autowired
    private ResultadoRepository repository;

    @Autowired
    private ResultadoMapper mapper;

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Transactional(readOnly = true)
    public List<ResultadoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ResultadoResponseDTO buscar(Long id) {
        Resultado entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Resultado não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ResultadoResponseDTO criar(ResultadoRequestDTO dto) {
        Resultado entity = mapper.toEntity(dto);
        Inscricao inscricao = inscricaoRepository.findById(dto.getInscricaoId())
            .orElseThrow(() -> new ResourceNotFoundException("Inscricao não encontrado com id: " + dto.getInscricaoId()));
        entity.setInscricao(inscricao);
        Resultado salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ResultadoResponseDTO atualizar(Long id, ResultadoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Resultado não encontrado com id: " + id);
        }
        Resultado entity = mapper.toEntity(dto);
        entity.setId(id);
        Inscricao inscricao = inscricaoRepository.findById(dto.getInscricaoId())
            .orElseThrow(() -> new ResourceNotFoundException("Inscricao não encontrado com id: " + dto.getInscricaoId()));
        entity.setInscricao(inscricao);
        Resultado salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Resultado não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
