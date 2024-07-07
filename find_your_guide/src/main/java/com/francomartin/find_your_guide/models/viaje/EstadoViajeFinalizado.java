package com.francomartin.find_your_guide.models.viaje;

import com.francomartin.find_your_guide.enums.EstadoPago;
import com.francomartin.find_your_guide.interfaces.IEstadoViaje;
import com.francomartin.find_your_guide.models.Factura;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class EstadoViajeFinalizado implements IEstadoViaje {
    @Override
    public Factura cancelar(Viaje contexto)
    {
        return null;
    }

    @Override
    public Factura finalizar(Viaje contexto)
    {
        contexto.setEstadoString("FINALIZADO");
        contexto.setEstado(new EstadoViajeFinalizado());
        var factura = Factura.builder()
                .turista(contexto.getReserva().getTurista())
                .viaje(contexto)
                .estadoPago(EstadoPago.IMPAGO)
                .total(contexto.calcularImporteFinal())
                .build();
        return factura;
    }
}
