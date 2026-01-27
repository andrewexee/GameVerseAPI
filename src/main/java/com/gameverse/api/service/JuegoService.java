package com.gameverse.api.service;

import com.gameverse.api.entity.Juego;
import com.gameverse.api.repository.JuegoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JuegoService {

    private final JuegoRepository juegoRepository;

    public JuegoService(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    // POST
    public Juego createJuego(Juego juego) {
        return juegoRepository.save(juego);
    }

    // GET
    public List<Juego> listJuegos() {
        return juegoRepository.findAll();
    }

    public Optional<Juego> getJuegoById(Long id) {
        return juegoRepository.findById(id);
    }

    // PUT
    public Juego updateJuego(Long id, Juego juegodetalles) {
        Optional<Juego> juegoOptional = juegoRepository.findById(id);
        if (juegoOptional.isPresent()) {
            Juego juego = juegoOptional.get();
            juego.setDescripcion(juegodetalles.getDescripcion());
            juego.setPrecio(juegodetalles.getPrecio());
            return juegoRepository.save(juego);
        } else {
            return null;
        }
    }

    // DELETE
    public void deleteJuego(Long id) {
        juegoRepository.deleteById(id);
    }
}
