package com.francomartin.find_your_guide.dtos;


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
    private String tipoAuth; // Puede ser "FACEBOOK", "APPLE", "GOOGLE", "EMAIL"
}
