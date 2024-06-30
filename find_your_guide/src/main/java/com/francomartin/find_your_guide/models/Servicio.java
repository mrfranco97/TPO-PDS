package com.francomartin.find_your_guide.models;


import com.francomartin.find_your_guide.enums.Idioma;
import com.francomartin.find_your_guide.enums.TipoServicio;
import jakarta.persistence.*;
import lombok.*;

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

    @Enumerated(EnumType.ORDINAL)
    private Idioma idioma;

    @Column(name = "nombre")
    private String nombre;

    @Enumerated(EnumType.ORDINAL)
    private TipoServicio tipo;

}
