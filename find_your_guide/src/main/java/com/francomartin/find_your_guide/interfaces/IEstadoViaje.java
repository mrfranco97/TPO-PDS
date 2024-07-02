package com.francomartin.find_your_guide.interfaces;



import com.francomartin.find_your_guide.models.viaje.Viaje;

public interface IEstadoViaje {

    void cancelar(Viaje contexto);

    void finalizar(Viaje contexto);
}
