package com.francomartin.find_your_guide.models.viaje;

import com.francomartin.find_your_guide.interfaces.IEstadoViaje;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class EstadoViajePendiente implements IEstadoViaje {
    @Override
    public void cancelar(Viaje contexto) {

    }

    @Override
    public void finalizar(Viaje contexto) {

    }
}
