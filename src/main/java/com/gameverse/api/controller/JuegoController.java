package com.gameverse.api.controller;

import com.gameverse.api.entity.Juego;
import com.gameverse.api.service.JuegoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/juegos")
public class JuegoController {

    private final JuegoService juegoService;

    public JuegoController(JuegoService juegoService) {
        this.juegoService = juegoService;
    }

    @GetMapping
    public List<Juego> listar() {
        return juegoService.listJuegos();
    }

    @GetMapping("/{id}")
    public Optional<Juego> buscar(@PathVariable Long id) {
        return juegoService.getJuegoById(id);
    }

    @PostMapping
    public Juego crear(@RequestBody Juego juego) {
        return juegoService.createJuego(juego);
    }

    @PutMapping("/{id}")
    public Juego actualizar(@PathVariable Long id, @RequestBody Juego juego) {
        return juegoService.updateJuego(id, juego);
    }
}
