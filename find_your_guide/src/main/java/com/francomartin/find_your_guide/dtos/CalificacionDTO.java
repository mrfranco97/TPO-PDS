package com.francomartin.find_your_guide.dtos;

import lombok.Data;

@Data
public class CalificacionDTO {
    private Long estrellas;
    private String comentario;
    private Long idAutor;
    private Long idDestinatario;
}
