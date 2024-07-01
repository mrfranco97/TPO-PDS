package com.francomartin.find_your_guide.models.viaje;

import com.francomartin.find_your_guide.models.*;
import com.francomartin.find_your_guide.models.reserva.Reserva;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fin", nullable = false)
    private Date fechaFin;

    @Transient
    private EstadoViaje estado;

    @OneToOne
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
