package com.fausto.tienda.models.services;

import com.fausto.tienda.models.dao.CategoriaDao;
import com.fausto.tienda.models.documents.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaDao dao;
    @Override
    public Mono<Categoria> crear(Categoria categoria) {
        return dao.save(categoria);
    }
}
