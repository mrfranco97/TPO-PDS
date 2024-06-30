package com.francomartin.find_your_guide.models;


import com.francomartin.find_your_guide.interfaces.IEstadoReserva;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Viaje> viajes;

    @Column(name = "porcentaje")
    private double porcentaje;

    @Embedded
    private IEstadoReserva estado;
}
