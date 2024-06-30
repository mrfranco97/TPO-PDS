package com.francomartin.find_your_guide.factories;


import com.francomartin.find_your_guide.dtos.ViajeDTO;
import com.francomartin.find_your_guide.models.*;
import com.francomartin.find_your_guide.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ViajeFactory {

    @Autowired
    private ViajeRepository viajeRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private TuristaRepository turistaRepository;

    @Autowired
    private GuiaRepository guiaRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    public Viaje createViaje(ViajeDTO viajeDTO) {
        try {
            Viaje viaje = new Viaje();
            Optional<Ciudad> ciudad = ciudadRepository.findById(viajeDTO.getCiudad_id());
            Optional<Turista> turista = turistaRepository.findById(viajeDTO.getTurista_id());
            Optional<Guia> guia = guiaRepository.findById(viajeDTO.getGuia_id());
            Optional<Reserva> reserva = reservaRepository.findById(viajeDTO.getReserva_id());

            if (viaje.validate(guia, ciudad, turista, reserva)) {
                viaje.setCiudad(ciudad.get());
                viaje.setTurista(turista.get());
                viaje.setGuia(guia.get());
                viaje.setReserva(reserva.get());

                viaje.setFechaInicio(viajeDTO.getFechaInicio());
                viaje.setFechaFin(viajeDTO.getFechaFin());

                viaje.cambiarEstado("pendiente");
            }

            return viaje;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
