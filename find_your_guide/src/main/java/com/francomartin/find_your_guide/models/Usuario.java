package com.francomartin.find_your_guide.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Long dni;
    private char sexo;
    private String email;
    private String telefono;
    private String fotoperfil;
    private String password;



    @JsonIgnore
    @OneToMany(mappedBy = "destinatario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Calificacion> resenias;

    @JsonIgnore
    @Transient
    private String trofeo;  // Variable para almacenar el nombre del trofeo

    public void agregarCalificacion(Calificacion calificacion) {
        resenias.add(calificacion);
        System.out.println("Calificación añadida. Total de reseñas: " + resenias.size());
    }

    // Getters y Setters
    public List<Calificacion> getResenias() {
        return resenias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTrofeo(String trofeo) {
        this.trofeo = trofeo;
        System.out.println("Trofeo asignado: " + trofeo);
    }

    public String getTrofeo() {
        return trofeo;
    }

}
