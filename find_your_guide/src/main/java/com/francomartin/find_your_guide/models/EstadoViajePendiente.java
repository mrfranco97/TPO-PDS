package com.francomartin.find_your_guide.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class EstadoViajePendiente extends EstadoViaje {

    public EstadoViajePendiente(){
        this.setName("pendiente");
    }

    @Override
    public void reservar(Usuario usuario) {
        Viaje viaje = this.getViaje();
        viaje.cambiarEstado("cancelado");
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
