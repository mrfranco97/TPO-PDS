package com.francomartin.find_your_guide.interfaces;


import com.francomartin.find_your_guide.models.Guia;
import com.francomartin.find_your_guide.models.Usuario;
import com.francomartin.find_your_guide.models.reserva.Reserva;
import com.francomartin.find_your_guide.models.Turista;

public interface IEstadoReserva {
    void cancelar(Usuario user, Reserva contexto);
    void aceptar(Reserva contexto);
}
