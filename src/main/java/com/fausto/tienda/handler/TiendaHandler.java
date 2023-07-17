package com.fausto.tienda.handler;
import com.fausto.tienda.models.services.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.*;

import static org.springframework.web.reactive.function.BodyInserters.*;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;


@Component
public class TiendaHandler {

    @Autowired
    private TiendaService service;


    public Mono<ServerResponse> searchAndSaveTienda(ServerRequest request){
        String id = request.pathVariable("id");
        return  service.searchAndSave(id).flatMap(t->ServerResponse
                .ok()
                .contentType(APPLICATION_JSON)
                .body(fromObject(t))
                .switchIfEmpty(ServerResponse.noContent().build())
        );
    }

    public  Mono<ServerResponse> updateField(ServerRequest request){
        String id= request.pathVariable("id");
        return service.updateProducto(id)
                .flatMap(p->ServerResponse
                .created(URI.create("/productos/".concat(p.getId())))
                .contentType(APPLICATION_JSON)
                .body(fromObject(p))).switchIfEmpty(ServerResponse.notFound().build());
    }




}
