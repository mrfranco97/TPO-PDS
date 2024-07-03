package com.francomartin.find_your_guide.interfaces;



import com.francomartin.find_your_guide.models.Factura;
import com.francomartin.find_your_guide.models.viaje.Viaje;

public interface IEstadoViaje {

    Factura cancelar(Viaje contexto);

    Factura finalizar(Viaje contexto);
}
