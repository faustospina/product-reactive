package com.fausto.tienda.mapper;

import com.fausto.tienda.client.dto.TiendaDTO;
import com.fausto.tienda.models.documents.Tienda;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TiendaMapper {
    Tienda ofTiendaMonoDto(TiendaDTO dto);
}
