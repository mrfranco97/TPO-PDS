package com.francomartin.find_your_guide.interfaces;


import com.francomartin.find_your_guide.models.Usuario;

public interface IEstadoViaje {
    void reservar(Usuario usuario);

    void cancelar(Usuario usuario);

    void concretar(Usuario usuario);

    void finalizar(Usuario usuario);
}
