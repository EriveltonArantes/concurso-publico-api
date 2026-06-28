package com.concursopublicoapi.mapper;

import com.concursopublicoapi.dto.ResultadoRequestDTO;
import com.concursopublicoapi.dto.ResultadoResponseDTO;
import com.concursopublicoapi.model.Resultado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResultadoMapper {

    @Mapping(target = "inscricao", ignore = true)
    Resultado toEntity(ResultadoRequestDTO dto);

    @Mapping(target = "inscricaoId", source = "inscricao.id")
    ResultadoResponseDTO toResponseDTO(Resultado entity);
}
