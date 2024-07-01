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
/*
    @PostMapping
    public Viaje createViaje(@RequestBody ViajeDTO viaje) {
        Viaje newViaje = viajeFactory.createViaje(viaje);
        viajeRepository.save(newViaje);
        return newViaje;
    }*/

}
