package com.francomartin.find_your_guide.models.reserva;

import com.francomartin.find_your_guide.interfaces.IEstadoReserva;
import com.francomartin.find_your_guide.models.Guia;
import com.francomartin.find_your_guide.models.Turista;
import com.francomartin.find_your_guide.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class EstadoReservaPendiente implements IEstadoReserva {
    @Override
    public void cancelar(Usuario user, Reserva contexto) {
        contexto.cambiarEstado(new EstadoReservaCancelado());
        contexto.setEstado("Cancelado");
    }
    @Override
    public void aceptar(Reserva contexto) {
        contexto.cambiarEstado(new EstadoReservaAceptado());
        contexto.setEstado("Aceptado");
    }
}
