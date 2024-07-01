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
@Table(name = "services")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "precio")
    private Double precio;

    @Enumerated(EnumType.STRING)
    @Column(name = "idioma")
    private Idioma idioma;

    @Column(name = "nombre")
    private String nombre;

    @Enumerated(EnumType.ORDINAL)
    private TipoServicio tipo;

    @ManyToOne
    @JoinColumn(name = "guia_id")
    private Guia guia;

}
