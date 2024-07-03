package com.francomartin.find_your_guide.controllers;

import com.francomartin.find_your_guide.dtos.ViajeDTO;
import com.francomartin.find_your_guide.factories.ViajeFactory;
import com.francomartin.find_your_guide.models.Factura;
import com.francomartin.find_your_guide.models.viaje.EstadoViajeCancelado;
import com.francomartin.find_your_guide.models.viaje.EstadoViajeFinalizado;
import com.francomartin.find_your_guide.models.viaje.Viaje;
import com.francomartin.find_your_guide.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private FacturaRepository facturaRepository;


    @PostMapping
    public ResponseEntity<Viaje> createViaje(@RequestBody ViajeDTO viaje) {
        Viaje newViaje = viajeFactory.createViaje(viaje);
        if (newViaje != null) {
            viajeRepository.save(newViaje);
            return ResponseEntity.ok(newViaje);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/cancelar")
    public ResponseEntity<?> cancelarViaje(@RequestParam Long id) {
        Optional<Viaje> request = viajeRepository.findById(id);
        if (request.isPresent()) {
            Viaje viaje = request.get();
            if(viaje.getEstadoString().equals("PENDIENTE")){
                Factura factura = viaje.cancelar();
                viajeRepository.save(viaje);
                facturaRepository.save(factura);
                return ResponseEntity.ok(factura);
            }
            else{
                return ResponseEntity.badRequest().body("El viaje se encuentra en un estado definitivo y no puede ser cancelado");
            }
        }
        return ResponseEntity.badRequest().body("No se encuentra viaje con el id " + id);
    }

    @PutMapping("/finalizar")
    public ResponseEntity<?> finalizarViaje(@RequestParam Long id) {
        Optional<Viaje> request = viajeRepository.findById(id);
        if (request.isPresent()) {
            Viaje viaje = request.get();
            if(viaje.getEstadoString().equals("PENDIENTE")){
                Factura factura = viaje.finalizar();
                viajeRepository.save(viaje);
                facturaRepository.save(factura);
                return ResponseEntity.ok(factura);
            }
            else{
                return ResponseEntity.badRequest().body("El viaje se encuentra en un estado definitivo y no puede ser cancelado");
            }
        }
        return ResponseEntity.badRequest().body("No se encuentra viaje con el id " + id);
        }
    }
