package com.fausto.tienda.models.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tiendas")
public class Tienda {
    @Id
    private String id;
    private String nombre;
    private List<Producto> productos;
}
