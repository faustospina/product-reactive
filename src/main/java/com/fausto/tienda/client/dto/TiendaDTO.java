package com.fausto.tienda.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiendaDTO {
    private String id;
    private String nombre;
    private List<ProductoDTO> productos;
}
