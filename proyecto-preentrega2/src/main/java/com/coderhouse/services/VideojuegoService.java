package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Videojuego;
import com.coderhouse.repositories.VideojuegoRepository;

import jakarta.transaction.Transactional;

@Service
public class VideojuegoService {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    public Videojuego findById(Long id) {
        return videojuegoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Videojuego no encontrado"));
    }

    public List<Videojuego> getAllVideojuegos() {
        return videojuegoRepository.findAll();
    }

    @Transactional
    public Videojuego updateVideojuegoById(Long id, Videojuego videojuegoDetails) {
        Videojuego videojuego = findById(id); 
        videojuego.setNombre(videojuegoDetails.getNombre());
        videojuego.setDescripcion(videojuegoDetails.getDescripcion());
        videojuego.setCategoria(videojuegoDetails.getCategoria());
        videojuego.setCliente(videojuegoDetails.getCliente());
        return videojuegoRepository.save(videojuego);
    }

    @Transactional
    public Videojuego saveVideojuego(Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    public void deleteVideojuegoById(Long id) {
        if (!videojuegoRepository.existsById(id)) {
            throw new IllegalArgumentException("Videojuego no encontrado");
        }
        videojuegoRepository.deleteById(id);
    }
}
