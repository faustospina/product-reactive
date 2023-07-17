package com.fausto.tienda.client.service;

import com.fausto.tienda.client.dto.ProductoDTO;
import com.fausto.tienda.client.dto.TiendaDTO;
import reactor.core.publisher.Mono;

public interface TiendaClientService {

    Mono<TiendaDTO> findById(String id);

    Mono<ProductoDTO> productofindById(String id);

}
