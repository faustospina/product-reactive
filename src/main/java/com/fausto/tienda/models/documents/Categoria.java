package com.fausto.tienda.models.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "categorias")
public class Categoria {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
}
