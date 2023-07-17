package com.fausto.tienda.models.services;

import com.fausto.tienda.models.documents.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {
    Mono<Producto> create(Producto producto);

    Mono<Producto> findById(String id);

    Flux<Producto> findAll();

    Flux<Producto> temp(String nombre, Double precio);

}
