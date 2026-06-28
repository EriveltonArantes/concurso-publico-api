package com.concursopublicoapi.mapper;

import com.concursopublicoapi.dto.InscricaoRequestDTO;
import com.concursopublicoapi.dto.InscricaoResponseDTO;
import com.concursopublicoapi.model.Inscricao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InscricaoMapper {

    @Mapping(target = "candidato", ignore = true)
    @Mapping(target = "concurso", ignore = true)
    Inscricao toEntity(InscricaoRequestDTO dto);

    @Mapping(target = "candidatoId", source = "candidato.id")
    @Mapping(target = "concursoId", source = "concurso.id")
    InscricaoResponseDTO toResponseDTO(Inscricao entity);
}
