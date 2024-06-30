package com.francomartin.find_your_guide.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ViajeDTO {
    private Long ciudad_id;
    private Long turista_id;
    private Long guia_id;
    private List<Long> servicios;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;
    private Long reserva_id;
}
