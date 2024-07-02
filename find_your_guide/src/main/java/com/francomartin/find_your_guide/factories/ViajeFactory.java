package com.francomartin.find_your_guide.factories;


import com.francomartin.find_your_guide.dtos.ViajeDTO;
import com.francomartin.find_your_guide.models.*;
import com.francomartin.find_your_guide.models.reserva.EstadoReservaPendiente;
import com.francomartin.find_your_guide.models.reserva.Reserva;
import com.francomartin.find_your_guide.models.viaje.EstadoViajePendiente;
import com.francomartin.find_your_guide.models.viaje.Viaje;
import com.francomartin.find_your_guide.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ViajeFactory {

    @Autowired
    private CiudadRepository ciudadRepository;
    @Autowired
    private TuristaRepository turistaRepository;
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private ServicioRepository servicioRepository;

    public Viaje createViaje(ViajeDTO viajeDTO) {
        Optional<Turista> autor = turistaRepository.findById(viajeDTO.getTuristaId());
        Optional<Ciudad> ciudad = ciudadRepository.findById(viajeDTO.getCiudadId());
        Optional<Servicio> servicio = servicioRepository.findById(viajeDTO.getServicioId());
        if (autor.isPresent() && servicio.isPresent() && ciudad.isPresent()) {

            var reserva = Reserva.builder()
                    .turista(autor.get())
                    .guia(servicio.get().getGuia())
                    .aniticipo(viajeDTO.getAnticipo())
                    .estadoClass(new EstadoReservaPendiente())
                    .estado("Pendiente")
                    .build();
            reservaRepository.save(reserva);
            var viaje = Viaje.builder()
                    .ciudad(ciudad.get())
                    .fechaInicio(viajeDTO.getFechaInicio())
                    .fechaFin(viajeDTO.getFechaFin())
                    .servicio(servicio.get())
                    .estadoString("Pendiente")
                    .estado(new EstadoViajePendiente())
                    .reserva(reserva)
                    .build();
            return viaje;
        }

        return null;
    }
}
