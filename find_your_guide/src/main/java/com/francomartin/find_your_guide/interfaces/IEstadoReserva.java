package com.francomartin.find_your_guide.interfaces;


import com.francomartin.find_your_guide.models.Guia;
import com.francomartin.find_your_guide.models.Reserva;
import com.francomartin.find_your_guide.models.Turista;

public interface IEstadoReserva {
    void cancelacionGuia(Guia guia, Reserva contexto);
    void cancelacionTurista(Turista turista, Reserva contexto);
    void reservar(Turista turista, Guia guia, Reserva contexto);
    void aceptar(Guia guia, Reserva contexto);
}
