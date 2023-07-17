package com.fausto.tienda.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private String id;
    private String nombre;
    private Double precio;
    private Integer stock;
    private CategoriaDTO categoria;
}
