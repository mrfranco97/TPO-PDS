package com.francomartin.find_your_guide.dtos;


import com.francomartin.find_your_guide.models.Calificacion;
import com.francomartin.find_your_guide.models.Usuario;
import com.francomartin.find_your_guide.repositories.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalificacionFactory {

    @Autowired
    private CalificacionRepository calificacionRepository;

    public Calificacion createCalificacion(CalificacionDTO calificacionDTO, Usuario autor, Usuario destinatario) {
        Calificacion calificacion = new Calificacion();
        calificacion.setComentario(calificacionDTO.getComentario());
        calificacion.setEstrellas(calificacionDTO.getEstrellas());
        calificacion.setAutor(autor);
        calificacion.setDestinatario(destinatario);

        calificacionRepository.save(calificacion);

        System.out.println("Calificación añadida para el destinatario: " + destinatario.getNombre());
        //destinatario.agregarCalificacion(calificacion); // Notificar a los trofeos

        return calificacion;
    }
}
