package com.francomartin.find_your_guide.controllers;


import com.francomartin.find_your_guide.dtos.ServicioDTO;
import com.francomartin.find_your_guide.factories.ServicioFactory;
import com.francomartin.find_your_guide.models.Servicio;
import com.francomartin.find_your_guide.repositories.ServicioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    private ServicioRepository servicioRepository;

    @GetMapping("/")
    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Servicio> createServicio(@RequestBody ServicioDTO servicio) {
        Servicio _servicio = ServicioFactory.createServicio(servicio);
        return ResponseEntity.ok(servicioRepository.save(_servicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> updateServicio(@PathVariable Long id, @RequestBody Servicio servicio) {
        Optional<Servicio> _servicio = servicioRepository.findById(id);
        if (_servicio.isPresent()) {
            Servicio updatedServicio = _servicio.get();
            updatedServicio.setTipo(servicio.getTipo());
            updatedServicio.setNombre(servicio.getNombre());
            updatedServicio.setPrecio(servicio.getPrecio());
            updatedServicio.setIdioma(servicio.getIdioma());
            return ResponseEntity.ok(servicioRepository.save(updatedServicio));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Servicio> deleteServicio(@PathVariable Long id) {
        Optional<Servicio> servicio = servicioRepository.findById(id);
        if (servicio.isPresent()) {
            servicioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
