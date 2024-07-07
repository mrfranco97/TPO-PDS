package com.francomartin.find_your_guide.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViajeDTO {
    private Long ciudadId;
    private Long turistaId;
    private Long servicioId;
    private Date fechaInicio;
    private Date fechaFin;
    private Double anticipo;
}
