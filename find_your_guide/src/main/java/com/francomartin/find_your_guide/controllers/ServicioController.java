package com.francomartin.find_your_guide.controllers;


import com.francomartin.find_your_guide.dtos.ServicioDTO;
import com.francomartin.find_your_guide.models.Guia;
import com.francomartin.find_your_guide.models.Servicio;
import com.francomartin.find_your_guide.repositories.GuiaRepository;
import com.francomartin.find_your_guide.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private GuiaRepository guiaRepository;

    @PostMapping("/")
    public ResponseEntity<Servicio> createServicio(@RequestBody ServicioDTO request) {
        Optional<Guia> optionalGuia = guiaRepository.findById(request.getGuiaId());
        if (!optionalGuia.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        var servicio=Servicio.builder()
                .nombre(request.getNombre())
                .precio(request.getPrecio())
                .tipo(request.getTipo())
                .guia(optionalGuia.get())
                .build();
        servicioRepository.save(servicio);
        return ResponseEntity.ok(servicioRepository.save(servicio));
    }

    @GetMapping("/")
    public ResponseEntity<List<Servicio>> getAllServicios() {
        List<Servicio> servicios = servicioRepository.findAll();
        if (servicios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.ok(servicios);
    }

}
