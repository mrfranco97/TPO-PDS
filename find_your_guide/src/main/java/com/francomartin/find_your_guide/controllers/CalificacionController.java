package com.francomartin.find_your_guide.controllers;


import com.francomartin.find_your_guide.dtos.CalificacionDTO;
import com.francomartin.find_your_guide.dtos.CalificacionFactory;
import com.francomartin.find_your_guide.models.Calificacion;
import com.francomartin.find_your_guide.models.Usuario;
import com.francomartin.find_your_guide.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calificacion")
public class CalificacionController {

    private static final Logger logger = LoggerFactory.getLogger(CalificacionController.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CalificacionFactory calificacionFactory;

    @PostMapping("/registrar")
    @Transactional
    public ResponseEntity<String> generarCalificacion(@RequestBody CalificacionDTO calificacionDTO) {
       /* Usuario autor = usuarioRepository.findById(calificacionDTO.getIdAutor())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Usuario destinatario = usuarioRepository.findById(calificacionDTO.getIdDestinatario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Calificacion calificacion = calificacionFactory.createCalificacion(calificacionDTO, autor, destinatario);
        return ResponseEntity.ok("Calificación generada exitosamente");*/
        return null;
    }
}
