package com.fausto.tienda.models.dao;

import com.fausto.tienda.models.documents.Producto;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoDao extends ReactiveMongoRepository<Producto,String> {
    @Query("{ 'categoria.nombre' : ?0, 'precio' : { $lt : ?1 } }")
    Flux<Producto> findByCategoriaPrecio(String nombre,Double precio);

}
