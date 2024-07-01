package com.francomartin.find_your_guide.repositories;


import com.francomartin.find_your_guide.models.viaje.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {

}
