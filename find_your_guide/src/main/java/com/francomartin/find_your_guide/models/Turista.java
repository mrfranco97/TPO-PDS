package com.francomartin.find_your_guide.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.francomartin.find_your_guide.models.reserva.Reserva;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Getter
@Setter
@Table(name = "turistas")
public class Turista extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "turista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    @JsonIgnore // Agregando esta anotación para evitar problemas de serialización bidireccional
    @OneToMany(mappedBy = "turista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Factura> facturas;

}
