package com.francomartin.find_your_guide.factories;


import com.francomartin.find_your_guide.dtos.GuiaDTO;
import com.francomartin.find_your_guide.dtos.UsuarioDTO;
import com.francomartin.find_your_guide.models.Guia;
import com.francomartin.find_your_guide.models.Turista;
import com.francomartin.find_your_guide.models.Usuario;
import com.francomartin.find_your_guide.repositories.GuiaRepository;
import com.francomartin.find_your_guide.repositories.TuristaRepository;
import com.francomartin.find_your_guide.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioFactory {

    @Autowired
    private GuiaRepository guiaRepository;

    @Autowired
    private TuristaRepository turistaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



    public Usuario createUsuario(UsuarioDTO datos) {
                var usuario = Turista.builder()
                        .nombre(datos.getNombre())
                        .apellido(datos.getApellido())
                        .dni(datos.getDni())
                        .sexo(datos.getSexo())
                        .email(datos.getEmail())
                        .telefono(datos.getTelefono())
                        .fotoperfil(datos.getFotoperfil())
                        .password(datos.getPassword())
                        .build();
                return usuario;

    }

    public Usuario createUsuario(GuiaDTO datos) {
        var usuario = Guia.builder()
                .nombre(datos.getNombre())
                .apellido(datos.getApellido())
                .dni(datos.getDni())
                .sexo(datos.getSexo())
                .email(datos.getEmail())
                .telefono(datos.getTelefono())
                .fotoperfil(datos.getFotoperfil())
                .licencia(datos.getLicencia())
                .password(datos.getPassword())
                .build();
        return usuario;

    }
}
