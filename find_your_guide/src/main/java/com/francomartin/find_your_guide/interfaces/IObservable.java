package com.francomartin.find_your_guide.interfaces;


import com.francomartin.find_your_guide.models.Usuario;

public interface IObservable {
    void agregar(Observer observer);
    void eliminar(Observer observer);
    void notificar(Usuario usuario);
}
