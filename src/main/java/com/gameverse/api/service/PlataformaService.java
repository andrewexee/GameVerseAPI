package com.gameverse.api.service;

import com.gameverse.api.entity.Categoria;
import com.gameverse.api.entity.Plataforma;
import com.gameverse.api.repository.PlataformaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlataformaService {
    private final PlataformaRepository plataformaRepository;

    public PlataformaService(PlataformaRepository plataformaRepository) {
        this.plataformaRepository = plataformaRepository;
    }

    // POST
    public Plataforma createPlataforma(Plataforma plataforma) {
        return plataformaRepository.save(plataforma);
    }

    // GET
    public List<Plataforma> listPlataformas() {
        return plataformaRepository.findAll();
    }

    public Optional<Plataforma> getPlataformaById(Long id) {
        return plataformaRepository.findById(id);
    }

    // PUT
    public Plataforma updatePlataforma(Long id, Plataforma plataformaDetalles) {
        Optional<Plataforma> plataformaOptional = plataformaRepository.findById(id);
        if (plataformaOptional.isPresent()) {
            Plataforma plataformaExistente = plataformaOptional.get();
            plataformaExistente.setNombre(plataformaDetalles.getNombre());
            return plataformaRepository.save(plataformaExistente);
        } else {
            return null;
        }
    }

    // DELETE
    public void deletePlataforma(Long id) {
        plataformaRepository.deleteById(id);
    }
}
