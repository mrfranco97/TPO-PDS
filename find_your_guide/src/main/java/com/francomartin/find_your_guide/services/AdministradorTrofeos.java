package com.francomartin.find_your_guide.services;


import com.francomartin.find_your_guide.interfaces.IObservable;
import com.francomartin.find_your_guide.interfaces.Observer;
import com.francomartin.find_your_guide.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AdministradorTrofeos implements IObservable {
    private List<Observer> observadores = new ArrayList<>();

    @Override
    public void agregar(Observer observer) {
        observadores.add(observer);
    }

    @Override
    public void eliminar(Observer observer) {
        observadores.remove(observer);
    }

    @Override
    public void notificar(Usuario usuario) {
        for (Observer observer : observadores) {
            observer.update(usuario);
        }
    }
}
