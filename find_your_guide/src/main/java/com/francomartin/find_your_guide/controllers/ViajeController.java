package com.francomartin.find_your_guide.controllers;

import com.francomartin.find_your_guide.dtos.ViajeDTO;
import com.francomartin.find_your_guide.factories.ViajeFactory;
import com.francomartin.find_your_guide.models.*;
import com.francomartin.find_your_guide.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/viajes")
public class ViajeController {

    @Autowired
    private ViajeRepository viajeRepository;

    @Autowired
    private GuiaRepository guiaRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private TuristaRepository turistaRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ViajeFactory viajeFactory;

    @GetMapping
    public List<Viaje> getAllViajes() {
        return viajeRepository.findAll();
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<Viaje> getViajeById(@PathVariable Long id) {
        Optional<Viaje> viaje = viajeRepository.findById(id);
        return viaje.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/turista/{id}")
    public List<Viaje> getViajeByTuristaId(@PathVariable Long id) {
        return viajeRepository.findAllByTuristaId(id);
    }

    @PostMapping
    public Viaje createViaje(@RequestBody ViajeDTO viaje) {
        Viaje newViaje = viajeFactory.createViaje(viaje);
        viajeRepository.save(newViaje);
        return newViaje;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viaje> updateViaje(@PathVariable Long id, @RequestBody ViajeDTO viajeDetails) {
        Optional<Viaje> viaje = viajeRepository.findById(id);
        Optional<Guia> guia = guiaRepository.findById(viajeDetails.getGuia_id());
        Optional<Ciudad> ciudad = ciudadRepository.findById(viajeDetails.getCiudad_id());
        Optional<Turista> turista = turistaRepository.findById(viajeDetails.getTurista_id());
        Optional<Reserva> reserva = reservaRepository.findById(viajeDetails.getReserva_id());

        if (viaje.isPresent()) {
            Viaje updatedViaje = viaje.get();
            if (updatedViaje.validate(guia, ciudad, turista, reserva)) {
                updatedViaje.setReserva(reserva.get());
                updatedViaje.setCiudad(ciudad.get());
                updatedViaje.setTurista(turista.get());
                updatedViaje.setGuia(guia.get());
                updatedViaje.setFechaInicio(viajeDetails.getFechaInicio());
                updatedViaje.setFechaFin(viajeDetails.getFechaFin());
                updatedViaje.cambiarEstado(viajeDetails.getEstado());
                return ResponseEntity.ok(viajeRepository.save(updatedViaje));
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViaje(@PathVariable Long id) {
        Optional<Viaje> viaje = viajeRepository.findById(id);
        if (viaje.isPresent()) {
            viajeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
