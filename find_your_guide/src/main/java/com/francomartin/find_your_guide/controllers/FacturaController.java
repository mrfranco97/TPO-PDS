package com.francomartin.find_your_guide.controllers;

import com.francomartin.find_your_guide.enums.EstadoPago;
import com.francomartin.find_your_guide.models.Factura;
import com.francomartin.find_your_guide.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;
    @PutMapping
    public ResponseEntity<Factura> pagar(@RequestParam Long id){
        Optional<Factura> request = facturaRepository.findById(id);
        if(request.isPresent())
        {
            Factura factura=request.get();
            factura.setEstadoPago(EstadoPago.PAGO);
            facturaRepository.save(factura);
            return ResponseEntity.ok(factura);
        }
        return ResponseEntity.badRequest().build();
    }
}
