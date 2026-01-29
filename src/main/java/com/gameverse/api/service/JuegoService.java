package com.gameverse.api.service;

import com.gameverse.api.dto.JuegoEnriquecidoDTO;
import com.gameverse.api.entity.Juego;
import com.gameverse.api.repository.JuegoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JuegoService {

    private final JuegoRepository juegoRepository;
    private final ExternalApiService externalApiService;


    public JuegoService(JuegoRepository juegoRepository, ExternalApiService externalApiService) {
        this.juegoRepository = juegoRepository;
        this.externalApiService = new ExternalApiService();
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


    public JuegoEnriquecidoDTO getJuegoEnriquecido(Long id) {
        // 1. Buscamos en nuestra base de datos local
        Juego juego = juegoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Juego no encontrado"));

        // 2. Llamamos a la API externa usando el nombre de nuestro juego local
        String urlPortada = externalApiService.getPortadaUrl(juego.getNombre());

        // 3. Fusionamos los datos en el DTO
        JuegoEnriquecidoDTO dto = new JuegoEnriquecidoDTO();
        dto.setId(juego.getId());
        dto.setNombre(juego.getNombre());
        dto.setDescripcion(juego.getDescripcion());
        dto.setPrecio(juego.getPrecio());
        dto.setPortadaUrl(urlPortada);

        return dto;
    }

}