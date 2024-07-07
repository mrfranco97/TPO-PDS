package com.francomartin.find_your_guide.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.francomartin.find_your_guide.interfaces.IObservable;
import com.francomartin.find_your_guide.interfaces.Observer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements IObservable {
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
    private String trofeo;

    @JsonIgnore
    @Transient
    private Observer observer;


    @JsonIgnore
    @OneToMany(mappedBy = "destinatario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Calificacion> reseniasRecibidas = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Calificacion> reseniasEnviadas = new ArrayList<>();


    public void agregarCalificacionRecibida(Calificacion calificacion) {
        reseniasRecibidas.add(calificacion);
        notificar(this);
    }

    public void agregarCalificacionEnviada(Calificacion calificacion) {
        reseniasEnviadas.add(calificacion);
        notificar(this);
    }


    public  void notificar(Usuario usuario){
        if(observer == null){
            observer = new TrofeoObserver();
        }
        observer.update(this);
    }

}

