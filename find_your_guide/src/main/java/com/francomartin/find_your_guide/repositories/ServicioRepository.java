package com.francomartin.find_your_guide.repositories;


import com.francomartin.find_your_guide.models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
}
