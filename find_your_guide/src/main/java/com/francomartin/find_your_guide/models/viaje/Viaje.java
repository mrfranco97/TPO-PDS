package com.francomartin.find_your_guide.models.viaje;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.francomartin.find_your_guide.interfaces.IEstadoViaje;
import com.francomartin.find_your_guide.models.*;
import com.francomartin.find_your_guide.models.reserva.Reserva;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "viajes")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="estado")
    private String estadoString;

    @OneToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "ciudad_id", nullable = false)
    private Ciudad ciudad;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fin", nullable = false)
    private Date fechaFin;


    @JsonIgnore
    @Transient
    private IEstadoViaje estado;

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    public Double calcularSubtotal(){
        return this.servicio.getPrecio() - this.reserva.getAniticipo();
    }

    public Double calcularComision(){
        return this.servicio.getPrecio() * 0.1;
    }

    public Double calcularImporteFinal(){
        return this.calcularSubtotal() + this.calcularComision();
    }

    public Factura cancelar() {
        Factura factura = this.getEstado().cancelar(this);
        return factura;
    };

    public Factura finalizar() {
        Factura factura = this.getEstado().finalizar(this);
        return factura;
    };


}
