package com.fausto.tienda.client.service;

import com.fausto.tienda.client.dto.ProductoDTO;
import com.fausto.tienda.client.dto.TiendaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class TiendaClientServiceImpl implements TiendaClientService {
    @Autowired
    private WebClient client;

    @Override
    public Mono<TiendaDTO> findById(String id) {
        Map<String,Object> params = new HashMap<>();
        params.put("id",id);
        return client.get().uri("/{id}",params)
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(TiendaDTO.class);
    }

    @Override
    public Mono<ProductoDTO> productofindById(String id) {
        Map<String,Object> params = new HashMap<>();
        params.put("id",id);
        return client.get().uri("/{id}",params)
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ProductoDTO.class);
    }
}
