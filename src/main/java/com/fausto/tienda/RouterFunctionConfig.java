package com.fausto.tienda;

import com.fausto.tienda.handler.CategoriaHandler;
import com.fausto.tienda.handler.ProductoHandler;
import com.fausto.tienda.handler.TiendaHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterFunctionConfig {

    @Value("${config.base.url}")
    private String url;

    @Bean
    public RouterFunction<ServerResponse> routesProductos(ProductoHandler handler){
        return route(POST(url + "/productos"),handler::crear)
                .andRoute(GET(url + "/productos"),handler::listar)
                .andRoute(GET(url + "/productos/{id}"),handler::ver)
                .andRoute(GET(url + "/producto")
                .and(RequestPredicates.queryParam("precio",t -> true))
                .and(RequestPredicates.queryParam("categoria",t-> true)), handler::productoPorCategoria);
    }

    @Bean
    public RouterFunction<ServerResponse> routesCategorias(CategoriaHandler handler){
        return route(POST(url + "/categorias"),handler::crear);
    }

    @Bean
    public RouterFunction<ServerResponse> routesTiendas(TiendaHandler handler){
        return route(GET(url + "/tiendas/{id}"),handler::searchAndSaveTienda)
                .andRoute(PUT(url + "/tiendas/{id}"),handler::updateField);
    }


}
