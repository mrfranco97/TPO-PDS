package com.francomartin.find_your_guide.services.auth;


import com.francomartin.find_your_guide.dtos.UsuarioDTO;
import com.francomartin.find_your_guide.interfaces.IAuth;
import org.springframework.stereotype.Component;

@Component
public class FacebookAuth implements IAuth {

    @Override
    public boolean registrar(UsuarioDTO datos) {
        // Lógica específica para registrar usuario con Facebook
        return true;
    }

    @Override
    public void login(UsuarioDTO datos) {
        // Lógica específica para iniciar sesión con Facebook
    }
}