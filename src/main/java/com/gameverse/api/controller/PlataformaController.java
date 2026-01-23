package com.gameverse.api.controller;

import com.gameverse.api.entity.Plataforma;
import com.gameverse.api.service.PlataformaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plataformas")
public class PlataformaController {

    private final PlataformaService plataformaService;

    public PlataformaController(PlataformaService plataformaService) {
        this.plataformaService = plataformaService;
    }

    @GetMapping
    public List<Plataforma> listar() {
        return plataformaService.listPlataformas();
    }

    @GetMapping("/{id}")
    public Optional<Plataforma> buscar(@PathVariable Long id) {
        return plataformaService.getPlataformaById(id);
    }

    @PostMapping
    public Plataforma crear(@RequestBody Plataforma plataforma) {
        return plataformaService.createPlataforma(plataforma);
    }

    @PutMapping("/{id}")
    public Plataforma actualizar(@PathVariable Long id, @RequestBody Plataforma plataforma) {
        return plataformaService.updatePlataforma(id, plataforma);
    }
}
