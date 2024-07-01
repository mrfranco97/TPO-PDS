package com.francomartin.find_your_guide.models.reserva;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.francomartin.find_your_guide.interfaces.IEstadoReserva;
import com.francomartin.find_your_guide.models.Guia;
import com.francomartin.find_your_guide.models.Turista;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "anticipo")
    private double aniticipo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "turista_id", nullable = false)
    private Turista turista;

    @ManyToOne
    @JoinColumn(name = "guia_id", nullable = false)
    private Guia guia;

    @Column(name="estado")
    private String estado;

    @Transient
    private IEstadoReserva estadoClass;

    void cambiarEstado(IEstadoReserva estado){
        this.estadoClass=estado;
    }
}
