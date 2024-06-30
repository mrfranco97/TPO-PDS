package com.francomartin.find_your_guide.repositories;


import com.francomartin.find_your_guide.models.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {

    List<Viaje> findAll();

    Viaje findById(long id);

    List<Viaje> findAllByTuristaId(long id);

    List<Viaje> findAllByGuiaId(long id);

    List<Viaje> findAllByCiudadId(long id);

}
