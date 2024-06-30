package com.francomartin.find_your_guide.dtos;


import com.francomartin.find_your_guide.enums.AuthTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuiaDTO {
    private String nombre;
    private String apellido;
    private Long dni;
    private char sexo;
    private String email;
    private String telefono;
    private String fotoperfil;
    private String password;
    private  String licencia;
    private List<String> ciudades;
    private AuthTipo authTipo;// Puede ser "FACEBOOK", "APPLE", "GOOGLE", "EMAIL"

}
