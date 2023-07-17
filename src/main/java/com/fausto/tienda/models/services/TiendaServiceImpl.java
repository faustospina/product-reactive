package com.fausto.tienda.models.services;

import com.fausto.tienda.client.dto.ProductoDTO;
import com.fausto.tienda.client.dto.TiendaDTO;
import com.fausto.tienda.client.service.TiendaClientService;
import com.fausto.tienda.mapper.TiendaMapper;
import com.fausto.tienda.models.dao.TiendaDao;
import com.fausto.tienda.models.documents.Producto;
import com.fausto.tienda.models.documents.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TiendaServiceImpl implements TiendaService {

    @Autowired
    private TiendaClientService tiendaClientService;

    @Autowired
    private TiendaDao dao;

    @Autowired
    private TiendaMapper map;

    @Autowired
    private ProductoService productoService;

    @Override
    public Mono<Tienda> searchAndSave(String id) {
        return tiendaClientService.findById(id)
                .flatMap(tdc->dao.save(map.ofTiendaMonoDto(tdc)));
    }

    @Override
    public Mono<Tienda> create(Tienda tienda) {
        return dao.save(tienda);
    }

    public Mono<Producto> updateProducto(String id){
        return tiendaClientService.productofindById(id).flatMap(productoDTO -> {
            String nombre = productoDTO.getNombre();
            String idProducto = productoDTO.getId();
            return productoService.findById(idProducto)
                    .flatMap(producto -> {
                        producto.setNombre(nombre);
                        return productoService.create(producto);
                    });
        });

    }


}
