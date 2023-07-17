package com.fausto.tienda.handler;
import com.fausto.tienda.models.documents.Categoria;
import com.fausto.tienda.models.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import static org.springframework.http.MediaType.*;

import static org.springframework.web.reactive.function.BodyInserters.*;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
@Component
public class CategoriaHandler {

    @Autowired
    private CategoriaService service;

    @Value("${config.base.url}")
    private String url;

    public Mono<ServerResponse> crear(ServerRequest request){
        Mono<Categoria> categoriaMono=request.bodyToMono(Categoria.class);

        return categoriaMono
                .flatMap(c->service.crear(c)
                        .flatMap(cdb->ServerResponse
                                .created(URI.create(url + "/categorias"))
                                .contentType(APPLICATION_JSON)
                                .body(fromObject(cdb)))

                );
    }




















}
