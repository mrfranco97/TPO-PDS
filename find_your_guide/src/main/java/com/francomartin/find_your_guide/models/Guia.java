package com.francomartin.find_your_guide.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.francomartin.find_your_guide.enums.Idioma;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "guias")
@Getter
@Setter
public class Guia extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licencia;

    @ElementCollection(targetClass = Idioma.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "guia_idiomas", joinColumns = @JoinColumn(name = "guia_id"))
    @Column(name = "idioma")
    private List<Idioma>idiomas = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "guia_ciudad",
            joinColumns = @JoinColumn(name = "guia_id"),
            inverseJoinColumns = @JoinColumn(name = "ciudad_id"))
    private List<Ciudad> ciudades = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "guia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servicio> servicios = new ArrayList<>();
}
