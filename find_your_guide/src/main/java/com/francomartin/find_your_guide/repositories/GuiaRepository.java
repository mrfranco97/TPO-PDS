package com.francomartin.find_your_guide.repositories;


import com.francomartin.find_your_guide.enums.Idioma;
import com.francomartin.find_your_guide.enums.TipoServicio;
import com.francomartin.find_your_guide.models.Guia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuiaRepository extends JpaRepository<Guia, Long> {

    @Query("SELECT g FROM Guia g " +
            "WHERE (:nombre IS NULL OR g.nombre LIKE %:nombre%)" +
            "AND (:apellido IS NULL OR g.apellido LIKE %:apellido%)"+
            //"AND (:ciudad IS NULL OR g.ciudades = :ciudad)" +
            "AND (:idioma IS NULL OR :idioma MEMBER OF g.idiomas) ")
            //"AND (:puntaje IS NULL OR g.puntaje >= :puntaje) " +

            //"AND (:servicio IS NULL OR :servicios = g.servicios)")
    List<Guia> buscarGuiasPorParametros(
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            //@Param("ciudad") String ciudad,
            //@Param("puntaje") Double puntaje,
            @Param("idioma") Idioma idioma);
            //@Param("servicio") TipoServicio servicio);

}
