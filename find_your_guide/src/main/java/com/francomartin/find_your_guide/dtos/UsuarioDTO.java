package com.francomartin.find_your_guide.dtos;


import com.francomartin.find_your_guide.enums.AuthTipo;
import lombok.Data;

@Data
public class UsuarioDTO {
    private String nombre;
    private String apellido;
    private Long dni;
    private char sexo;
    private String email;
    private String telefono;
    private String fotoperfil;
    private String password;
    private AuthTipo authTipo;// Puede ser "FACEBOOK", "APPLE", "GOOGLE", "EMAIL"
}
