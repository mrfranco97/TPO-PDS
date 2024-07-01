package com.francomartin.find_your_guide.repositories;


import com.francomartin.find_your_guide.models.reserva.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
