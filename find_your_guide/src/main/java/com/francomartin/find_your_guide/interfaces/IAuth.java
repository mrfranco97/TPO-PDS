package com.francomartin.find_your_guide.interfaces;


import com.francomartin.find_your_guide.dtos.UsuarioDTO;

public interface IAuth {
    boolean registrar(UsuarioDTO datos);
    void login(UsuarioDTO datos);
}
