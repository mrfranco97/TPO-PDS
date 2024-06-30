package com.francomartin.find_your_guide.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;


@SuperBuilder
@AllArgsConstructor
@Entity
@Table(name = "guias")
@Getter
@Setter
public class Guia extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licencia;

    @JsonIgnore
    @OneToMany
    private List<Ciudad> ciudades;

    private String trofeo;

    public Guia() {
        super();
        //this.agregarTrofeo(new TrofeoExito(1, "Trofeo de Éxito", 4.5));
    }
}
