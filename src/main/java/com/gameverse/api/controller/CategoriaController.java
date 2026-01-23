package com.gameverse.api.controller;

import com.gameverse.api.entity.Categoria;
import com.gameverse.api.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listCategorias();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> buscar(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id);
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria categoria) {
        return categoriaService.createCategoria(categoria);
    }

    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaService.updateCategoria(id, categoria);
    }
}
