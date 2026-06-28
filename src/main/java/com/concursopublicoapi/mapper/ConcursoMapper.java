package com.concursopublicoapi.mapper;

import com.concursopublicoapi.dto.ConcursoRequestDTO;
import com.concursopublicoapi.dto.ConcursoResponseDTO;
import com.concursopublicoapi.model.Concurso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConcursoMapper {

    Concurso toEntity(ConcursoRequestDTO dto);

    ConcursoResponseDTO toResponseDTO(Concurso entity);
}
