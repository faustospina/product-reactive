package com.fausto.tienda.handler;

import com.fausto.tienda.models.documents.Producto;
import com.fausto.tienda.models.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import static org.springframework.http.MediaType.*;

import static org.springframework.web.reactive.function.BodyInserters.*;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class ProductoHandler {

    @Autowired
    private ProductoService service;

    @Value("${config.base.url}")
    private String url;

    public Mono<ServerResponse> crear(ServerRequest request){
        Mono<Producto> producto=request.bodyToMono(Producto.class);
        return producto
                .flatMap(p->service.create(p)
                        .flatMap(pdb->ServerResponse
                                .created(URI.create(url + "/productos".concat(pdb.getId())))
                                .contentType(APPLICATION_JSON)
                                .body(fromObject(pdb))
                        )
                );
    }

    public Mono<ServerResponse> listar(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(APPLICATION_JSON)
                .body(service.findAll(),Producto.class);
    }

    public Mono<ServerResponse> ver(ServerRequest request){
        String id = request.pathVariable("id");
        return service.findById(id).flatMap(
                p->ServerResponse
                        .ok()
                        .contentType(APPLICATION_JSON)
                        .body(fromObject(p))
                        .switchIfEmpty(ServerResponse.noContent().build())
                ).switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> productoPorCategoria(ServerRequest request) {
        Double precio = Double.parseDouble(request.queryParam("precio").orElse(" 0 "));
        String categoriaNombre = request.queryParam("categoria").orElse("");

        return service.temp(categoriaNombre, precio)
                .collectList()
                .flatMap(productos -> {
                    if (!productos.isEmpty()) {
                        // Procesar la lista de productos
                        return ServerResponse.ok()
                                .contentType(APPLICATION_JSON)
                                .bodyValue(productos);
                    } else {
                        return ServerResponse.notFound().build();
                    }
                });
    }



























}
