package com.fausto.tienda.models.dao;

import com.fausto.tienda.models.documents.Tienda;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TiendaDao extends ReactiveMongoRepository<Tienda,String> {
}
