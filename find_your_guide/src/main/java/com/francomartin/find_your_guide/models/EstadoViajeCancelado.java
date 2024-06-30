package com.francomartin.find_your_guide.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class EstadoViajeCancelado extends EstadoViaje {

    public EstadoViajeCancelado() {
        this.setName("cancelado");
    }

    @Override
    public void reservar(Usuario usuario) {
    }

    @Override
    public void cancelar(Usuario user) {
    }

    @Override
    public void concretar(Usuario usuario) {
    }

    @Override
    public void finalizar(Usuario usuario) {
    }

}
