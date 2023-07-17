package com.fausto.tienda;

import com.fausto.tienda.models.documents.Categoria;
import com.fausto.tienda.models.documents.Producto;
import com.fausto.tienda.models.documents.Tienda;
import com.fausto.tienda.models.services.CategoriaService;
import com.fausto.tienda.models.services.ProductoService;
import com.fausto.tienda.models.services.TiendaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class TiendaApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(TiendaApplication.class);

	@Autowired
	private ReactiveMongoTemplate template;

	@Autowired
	private TiendaService tiendaService;

	@Autowired
	private ProductoService productoService;

	@Autowired
	private CategoriaService categoriaService;




	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*template.dropCollection("categorias").subscribe();
		template.dropCollection("productos").subscribe();
		template.dropCollection("tiendas").subscribe();

		Categoria laptop = Categoria.builder().nombre("Laptop").descripcion("Computadores portatiles").build();
		Categoria smartphone=Categoria.builder().nombre("Smartphone").descripcion("Celulares inteligentes").build();
		Categoria neveras = Categoria.builder().nombre("Neveras").descripcion("Neveras producto para el hogar").build();
		Categoria televisores =Categoria.builder().nombre("Televisores").descripcion("Televisores para el hogar").build();
		Categoria microhondas = Categoria.builder().nombre("Microhondas").descripcion("Microhondas para el hogar").build();

		Producto producto1 = Producto.builder().nombre("Mac Book Pro").precio(3000.00).stock(40).categoria(laptop).build();
		Producto producto2 = Producto.builder().nombre("Iphone 12").precio(2000.00).stock(40).categoria(smartphone).build();
		Producto producto3 = Producto.builder().nombre("Samsung Tv 55").precio(1500.00).stock(40).categoria(televisores).build();
		Producto producto4 = Producto.builder().nombre("Mac Book Slim").precio(2000.00).stock(40).categoria(laptop).build();
		Producto producto5 = Producto.builder().nombre("kalei").precio(700.00).stock(40).categoria(microhondas).build();
		Producto producto6 = Producto.builder().nombre("LG").precio(3000.00).stock(40).categoria(neveras).build();
		Producto producto7 = Producto.builder().nombre("LG Tv 45").precio(800.00).stock(40).categoria(televisores).build();
		Producto producto8 = Producto.builder().nombre("ASUS").precio(1500.00).stock(40).categoria(laptop).build();
		List<Producto> productos = new ArrayList<>();
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);
		productos.add(producto4);
		productos.add(producto5);
		productos.add(producto6);
		productos.add(producto7);
		productos.add(producto8);

		Flux.just(laptop,smartphone,neveras,televisores,microhondas)
				.flatMap(categoriaService::crear)
				.doOnNext(c->log.info("Categoria Creada: "+c.getNombre()+", "+c.getId()))
				.thenMany(Flux.just(producto1,producto2,producto3,producto4,producto5,producto6,producto7,producto8)
						.flatMap(productoService::create)
						.doOnNext(p->log.info("Producto Creado: "+p.getNombre()+", "+p.getId()))
				)
				.then(Mono.just(Tienda.builder().nombre("Exito").productos(productos).build())
						.flatMap(tiendaService::create)
				).subscribe(tienda -> log.info("Insert: " + tienda.getNombre()));*/

	}



















}
