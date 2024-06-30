package com.francomartin.find_your_guide.factories;


import com.francomartin.find_your_guide.dtos.ServicioDTO;
import com.francomartin.find_your_guide.models.Servicio;
import org.springframework.stereotype.Component;

@Component
public class ServicioFactory {

    public static Servicio createServicio(ServicioDTO servicio) {
        Servicio newServicio = new Servicio();
        newServicio.setNombre(servicio.getNombre());
        newServicio.setPrecio(servicio.getPrecio());
        newServicio.setIdioma(servicio.getIdioma());
        newServicio.setTipo(servicio.getTipo());
        return newServicio;
    }
}
