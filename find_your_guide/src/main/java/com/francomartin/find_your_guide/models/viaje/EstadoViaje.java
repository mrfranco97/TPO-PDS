package com.francomartin.find_your_guide.models.viaje;


import com.francomartin.find_your_guide.interfaces.IEstadoViaje;
import com.francomartin.find_your_guide.models.Usuario;
import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Embeddable
@Data
public abstract class EstadoViaje implements IEstadoViaje {

    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "viaje_id")
    private Viaje viaje;

    @Override
    public void reservar(Usuario usuario) {

    }

    @Override
    public void cancelar(Usuario usuario) {

    }

    @Override
    public void concretar(Usuario usuario) {

    }

    @Override
    public void finalizar(Usuario usuario) {

    }

}
