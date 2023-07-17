package com.fausto.tienda.models.services;

import com.fausto.tienda.models.documents.Producto;
import com.fausto.tienda.models.documents.Tienda;
import reactor.core.publisher.Mono;

public interface TiendaService {

    Mono<Tienda> searchAndSave(String id);

    Mono<Tienda> create(Tienda tienda);

    Mono<Producto> updateProducto(String id);

}
