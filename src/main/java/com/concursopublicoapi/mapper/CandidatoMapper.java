package com.concursopublicoapi.mapper;

import com.concursopublicoapi.dto.CandidatoRequestDTO;
import com.concursopublicoapi.dto.CandidatoResponseDTO;
import com.concursopublicoapi.model.Candidato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CandidatoMapper {

    Candidato toEntity(CandidatoRequestDTO dto);

    CandidatoResponseDTO toResponseDTO(Candidato entity);
}
