package com.francomartin.find_your_guide.factories;


import com.francomartin.find_your_guide.dtos.GuiaDTO;
import com.francomartin.find_your_guide.dtos.UsuarioDTO;
import com.francomartin.find_your_guide.models.*;
import com.francomartin.find_your_guide.repositories.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioFactory {

    @Autowired
    private CiudadRepository ciudadRepository;




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

        List<Ciudad> ciudades = datos.getCiudades().stream()
                .map(ciudadNombre -> ciudadRepository.findByNombre(ciudadNombre).orElse(null))
                .filter(ciudad -> ciudad != null)
                .collect(Collectors.toList());

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
                .ciudades(ciudades)
                .build();
        return usuario;

    }
}
