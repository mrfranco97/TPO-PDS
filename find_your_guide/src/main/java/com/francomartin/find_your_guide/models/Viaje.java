package com.francomartin.find_your_guide.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "viajes")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;

    @OneToOne
    @JoinColumn(name = "ciudad_id", nullable = false)
    private Ciudad ciudad;

    @OneToOne
    @JoinColumn(name = "turista_id", nullable = false)
    private Turista turista;

    @OneToOne
    @JoinColumn(name = "guia_id", nullable = false)
    private Guia guia;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fin", nullable = false)
    private Date fechaFin;

    @Embedded
    private EstadoViaje estado;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    public void cambiarEstado(String estado) {
        if (Objects.equals(estado, "cancelado")) {
            EstadoViaje _estado = new EstadoViajeCancelado();
            _estado.setViaje(this);
            this.estado = _estado;
        }

        if (Objects.equals(estado, "pendiente")) {
            EstadoViaje _estado = new EstadoViajePendiente();
            _estado.setViaje(this);
            this.estado = _estado;
        }
    }

    public Boolean validate(
            Optional<Guia> guia,
            Optional<Ciudad> ciudad,
            Optional<Turista> turista,
            Optional<Reserva> reserva
    ) {
        return guia.isPresent()
                && ciudad.isPresent()
                && turista.isPresent()
                && reserva.isPresent();
    }

}
