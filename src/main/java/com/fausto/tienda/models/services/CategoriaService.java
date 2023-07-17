package com.fausto.tienda.models.services;

import com.fausto.tienda.models.documents.Categoria;
import reactor.core.publisher.Mono;

public interface CategoriaService {

    Mono<Categoria> crear(Categoria categoria);
}
