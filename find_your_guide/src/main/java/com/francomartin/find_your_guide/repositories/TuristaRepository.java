package com.francomartin.find_your_guide.repositories;


import com.francomartin.find_your_guide.models.Turista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuristaRepository extends JpaRepository<Turista, Long> {
}
