package com.francomartin.find_your_guide.repositories;


import com.francomartin.find_your_guide.models.Guia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuiaRepository extends JpaRepository<Guia, Long> {
}
