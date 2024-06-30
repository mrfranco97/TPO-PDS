package com.francomartin.find_your_guide.models;

import com.francomartin.find_your_guide.interfaces.Observer;


public class TrofeoObserver implements Observer {

    @Override
    public void update(Usuario usuario) {
        if (usuario instanceof Guia) {
            System.out.println("Activo Guia");
            int cantResenias=usuario.getReseniasRecibidas().size();
            if(cantResenias>=10){
                double promedioCalificacion = usuario.getReseniasRecibidas().stream()
                        .mapToDouble(Calificacion::getEstrellas)
                        .average()
                        .orElse(0.0);
                if (promedioCalificacion >= 4.5) {
                    usuario.setTrofeo("Trofeo al Exito");

                }
            }
        }
        else {
            int cantResenias = usuario.getReseniasEnviadas().size();
            System.out.println("Activo Turista");
            if(cantResenias>=10){
                usuario.setTrofeo("Trofeo a la reseña");
            }
        }
    }
}
