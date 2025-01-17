package com.francomartin.find_your_guide.controllers;


import com.francomartin.find_your_guide.dtos.GuiaDTO;
import com.francomartin.find_your_guide.dtos.UsuarioDTO;
import com.francomartin.find_your_guide.enums.AuthTipo;
import com.francomartin.find_your_guide.enums.Idioma;
import com.francomartin.find_your_guide.enums.TipoServicio;
import com.francomartin.find_your_guide.factories.UsuarioFactory;
import com.francomartin.find_your_guide.interfaces.IAuth;
import com.francomartin.find_your_guide.models.Ciudad;
import com.francomartin.find_your_guide.models.Guia;
import com.francomartin.find_your_guide.models.viaje.Viaje;
import com.francomartin.find_your_guide.repositories.GuiaRepository;
import com.francomartin.find_your_guide.repositories.TuristaRepository;
import com.francomartin.find_your_guide.repositories.UsuarioRepository;
import com.francomartin.find_your_guide.services.auth.AppleAuth;
import com.francomartin.find_your_guide.services.auth.EmailAuth;
import com.francomartin.find_your_guide.services.auth.FacebookAuth;
import com.francomartin.find_your_guide.services.auth.GoogleAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GuiaRepository guiaRepository;

    @Autowired
    private TuristaRepository turistaRepository;

    @Autowired
    private UsuarioFactory usuarioFactory;

    @Autowired
    private FacebookAuth facebookAuth;

    @Autowired
    private AppleAuth appleAuth;

    @Autowired
    private GoogleAuth googleAuth;

    @Autowired
    private EmailAuth emailAuth;

    @PostMapping("/registrar/turista")
    public ResponseEntity<String> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        logger.info("Iniciando registro de turista");

        // Registrar credenciales de usuario
        IAuth auth = getAuthProvider(usuarioDTO.getAuthTipo());
        auth.registrar(usuarioFactory.createUsuario(usuarioDTO));

        return ResponseEntity.ok("Turista registrado exitosamente");
    }

    @PostMapping("/registrar/guia")
    public ResponseEntity<String> registrarUsuario(@RequestBody GuiaDTO usuarioDTO) {
        logger.info("Iniciando registro de turista");

        // Registrar credenciales de usuario
        IAuth auth = getAuthProvider(usuarioDTO.getAuthTipo());
        auth.registrar(usuarioFactory.createUsuario(usuarioDTO));

        return ResponseEntity.ok("Guia registrado exitosamente");
    }

    @GetMapping("/guias/all")
    public ResponseEntity<List<Guia>> getAllGuias() {
        List<Guia> guias = guiaRepository.findAll();
        if (guias.isEmpty()) {
            logger.info("No se encontraron guías.");
            return ResponseEntity.noContent().build();
        } else {
            logger.info("Guías encontradas: " + guias.size());
            return ResponseEntity.ok(guias);
        }
    }
    @GetMapping("/guias/parametros")
    public ResponseEntity<List<Guia>> buscarGuia(@RequestParam(required = false) String nombre,
                                            @RequestParam(required = false) String apellido,
                                            @RequestParam(required = false) String ciudad,
                                            @RequestParam(required = false) Idioma idioma,
                                            @RequestParam(required = false) Double puntaje,
                                            @RequestParam(required = false) TipoServicio tipoServicio) {
        //return guiaRepository.buscarGuiasPorParametros(nombre,apellido,idioma);
        return ResponseEntity.ok(guiaRepository.buscarGuiasPorParametros(nombre,apellido,idioma));

    }
    /*
    @PostMapping("/login")
    public ResponseEntity<String> loginUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        logger.info("Iniciando login de usuario");
        IAuth auth = getAuthProvider(usuarioDTO.getTipoAuth());
        auth.login(usuarioDTO);
        return ResponseEntity.ok("Inicio de sesión exitoso");
    }*/

    private IAuth getAuthProvider(AuthTipo tipoAuth) {
        return switch (tipoAuth) {
            case FACEBOOK -> facebookAuth;
            case APPLE -> appleAuth;
            case GOOGLE -> googleAuth;
            case EMAIL -> emailAuth;
            default -> throw new IllegalArgumentException("Tipo de autenticación no soportado: " + tipoAuth);
        };
    }
}
