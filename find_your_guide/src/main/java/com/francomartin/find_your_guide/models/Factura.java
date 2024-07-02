package com.francomartin.find_your_guide.models;


import com.francomartin.find_your_guide.enums.EstadoPago;
import com.francomartin.find_your_guide.models.viaje.Viaje;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="viaje_id", nullable = false)
    private Viaje viaje;

    @ManyToOne
    @JoinColumn(name = "turista_id", nullable = false)
    private Turista turista;

    @Enumerated(EnumType.STRING)
    private EstadoPago estadoPago;

    @Column(name = "Total")
    private Double total;
}
