package com.francomartin.find_your_guide.services.auth;


import com.francomartin.find_your_guide.dtos.UsuarioDTO;
import com.francomartin.find_your_guide.interfaces.IAuth;
import org.springframework.stereotype.Component;

@Component
public class AppleAuth implements IAuth {

    @Override
    public boolean registrar(UsuarioDTO datos) {
        // Lógica específica para registrar usuario con Apple
        return true;
    }

    @Override
    public void login(UsuarioDTO datos) {
        // Lógica específica para iniciar sesión con Apple
    }
}
