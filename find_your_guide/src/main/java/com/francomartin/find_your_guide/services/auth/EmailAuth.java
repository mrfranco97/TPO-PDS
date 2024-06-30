package com.francomartin.find_your_guide.services.auth;


import com.francomartin.find_your_guide.dtos.UsuarioDTO;
import com.francomartin.find_your_guide.interfaces.IAuth;
import com.francomartin.find_your_guide.models.Usuario;
import com.francomartin.find_your_guide.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailAuth implements IAuth {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void registrar(Usuario datos) {
        // Verificar si el email ya está registrado
        if (usuarioRepository.findByEmail(datos.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email ya está registrado");
        }
        else{
            usuarioRepository.save(datos);
        }

    }

    @Override
    public void login(UsuarioDTO datos) {
        // Verificar las credenciales del usuario
        Usuario usuario = usuarioRepository.findByEmail(datos.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Credenciales inválidas"));

        if (!datos.getPassword().equals(usuario.getPassword())) {
            throw new IllegalArgumentException("Credenciales inválidas");
        }
    }
}
