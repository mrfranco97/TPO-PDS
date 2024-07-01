package com.francomartin.find_your_guide.dtos;


import com.francomartin.find_your_guide.enums.TipoServicio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDTO {
    private String nombre;
    private Double precio;
    private TipoServicio tipo;
    private Long guiaId;
}
