package com.fausto.tienda.models.services;

import com.fausto.tienda.models.dao.ProductoDao;
import com.fausto.tienda.models.documents.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao dao;
    @Override
    public Mono<Producto> create(Producto producto) {
        return  dao.save(producto);
    }

    @Override
    public Mono<Producto> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Flux<Producto> findAll() {
        return dao.findAll();
    }

    @Override
    public Flux<Producto> temp(String nombre, Double precio) {
        return dao.findByCategoriaPrecio(nombre,precio);
    }

}
