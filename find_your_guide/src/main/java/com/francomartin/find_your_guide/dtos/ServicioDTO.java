package com.francomartin.find_your_guide.dtos;


import com.francomartin.find_your_guide.enums.Idioma;
import com.francomartin.find_your_guide.enums.TipoServicio;
import lombok.Data;


@Data
public class ServicioDTO {
    private String nombre;
    private Double precio;
    private Idioma idioma;
    private TipoServicio tipo;
}
