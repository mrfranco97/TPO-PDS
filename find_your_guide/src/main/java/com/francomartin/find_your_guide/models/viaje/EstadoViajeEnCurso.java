package com.francomartin.find_your_guide.models.viaje;

import com.francomartin.find_your_guide.models.Usuario;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class EstadoViajeEnCurso extends EstadoViaje {

    @Override
    public void reservar(Usuario usuario) {
        Viaje viaje = this.getViaje();
        viaje.cambiarEstado("pendiente");
    }

    @Override
    public void cancelar(Usuario user) {
        Viaje viaje = this.getViaje();
        viaje.cambiarEstado("cancelado");
    }

    @Override
    public void concretar(Usuario usuario) {
        Viaje viaje = this.getViaje();
        // EstadoViaje nuevoEstado = new
    }

    @Override
    public void finalizar(Usuario usuario) {
        Viaje viaje = this.getViaje();
        // EstadoViaje nuevoEstado = new
    }

}
