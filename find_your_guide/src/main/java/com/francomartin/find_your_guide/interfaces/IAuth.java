package com.francomartin.find_your_guide.interfaces;


import com.francomartin.find_your_guide.dtos.UsuarioDTO;
import com.francomartin.find_your_guide.models.Usuario;

public interface IAuth {
    void registrar(Usuario datos);
    void login(UsuarioDTO datos);
}
