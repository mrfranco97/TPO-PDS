package com.francomartin.find_your_guide.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.francomartin.find_your_guide.enums.Idioma;
import com.francomartin.find_your_guide.enums.TipoServicio;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "services")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "nombre")
    private String nombre;

    @Enumerated(EnumType.ORDINAL)
    private TipoServicio tipo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "guia_id")
    private Guia guia;

}
