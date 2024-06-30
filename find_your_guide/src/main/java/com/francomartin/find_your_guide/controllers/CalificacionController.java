package com.francomartin.find_your_guide.controllers;


import com.francomartin.find_your_guide.dtos.CalificacionDTO;
import com.francomartin.find_your_guide.models.Calificacion;
import com.francomartin.find_your_guide.models.Guia;
import com.francomartin.find_your_guide.models.Turista;
import com.francomartin.find_your_guide.repositories.CalificacionRepository;
import com.francomartin.find_your_guide.repositories.GuiaRepository;
import com.francomartin.find_your_guide.repositories.TuristaRepository;
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
    private TuristaRepository turistaRepository;

    @Autowired
    private GuiaRepository guiaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CalificacionRepository calificacionRepository;

    @PostMapping("/registrar")
    @Transactional
    public ResponseEntity<String> generarCalificacion(@RequestBody CalificacionDTO calificacionDTO) {
        Turista autor = turistaRepository.findById(calificacionDTO.getIdAutor())
                .orElseThrow(() -> new RuntimeException("Turista no encontrado"));
        Guia destinatario = guiaRepository.findById(calificacionDTO.getIdDestinatario())
                .orElseThrow(() -> new RuntimeException("Guia no encontrado"));

        var calificacion= Calificacion.builder()
                .autor(autor)
                .destinatario(destinatario)
                .estrellas(calificacionDTO.getEstrellas())
                .comentario(calificacionDTO.getComentario())
                .build();
        calificacionRepository.save(calificacion);
        autor.agregarCalificacionRecibida(calificacion);
        destinatario.agregarCalificacionRecibida(calificacion);
        usuarioRepository.save(autor);
        usuarioRepository.save(destinatario);
        return ResponseEntity.ok("Calificación generada exitosamente");
    }
}
