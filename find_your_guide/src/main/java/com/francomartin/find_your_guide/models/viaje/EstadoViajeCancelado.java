package com.francomartin.find_your_guide.models.viaje;

import com.francomartin.find_your_guide.interfaces.IEstadoViaje;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class EstadoViajeCancelado implements IEstadoViaje {
    @Override
    public void cancelar(Viaje contexto) {

    }

    @Override
    public void finalizar(Viaje contexto) {

    }
}
