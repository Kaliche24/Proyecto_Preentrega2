package com.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coderhouse.models.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    
}
