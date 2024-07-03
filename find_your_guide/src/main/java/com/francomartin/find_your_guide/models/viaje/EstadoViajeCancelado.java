package com.francomartin.find_your_guide.models.viaje;

import com.francomartin.find_your_guide.enums.EstadoPago;
import com.francomartin.find_your_guide.interfaces.IEstadoViaje;
import com.francomartin.find_your_guide.models.Factura;
import com.francomartin.find_your_guide.repositories.FacturaRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@NoArgsConstructor
public class EstadoViajeCancelado implements IEstadoViaje {
    @Override
    public Factura cancelar(Viaje contexto) {
        return null;
    }

    @Override
    public Factura finalizar(Viaje contexto) {
        return null;
    }
}
