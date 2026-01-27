package com.gameverse.api.service;

import com.gameverse.api.entity.Categoria;
import com.gameverse.api.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    // POST
    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    // GET
    public List<Categoria> listCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> getCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }
    // PUT
    public Categoria updateCategoria(Long id, Categoria categoriaDetalles) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
            Categoria categoriaExistente = categoriaOptional.get();
            categoriaExistente.setNombre(categoriaDetalles.getNombre());
            return categoriaRepository.save(categoriaExistente);
        } else {
            return null; // O lanzar una excepción según la lógica de tu aplicación
        }
    }
    // DELETE
    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
