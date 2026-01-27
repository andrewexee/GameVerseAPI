package com.gameverse.api.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrés Iglesias Camacho
 * @date 15.01.2026
 */
// Establecemos que la clase es una entidad con la etiqueta de JPA
// Determinamos que es una tabla de nuestra DB
@Entity
@Table(name="plataforma")
public class Plataforma {
    // Cuando creamos una entidad, necesitamos de al menos, una Primary Key

    // ========================== DESARROLLO ATRIBUTOS ==========================

    // Establecemos que el atributo va ha ser un ID
    // Establecemos que el atributo va ha ser autoincrementativo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Establecemos que la columna "nombre" va ha ser nullable y unique
    @Column(unique = true,
            nullable = false)
    private String nombre;

    // Esto deriva en la Tabla Intermedia (TI2)
    @ManyToMany(mappedBy = "listPlataformas")
    private List<Juego> listJuegos = new ArrayList<>();

    // ========================== DESARROLLO CONSTRUCTORES ==========================

    public Plataforma() {
        // Constructor vacío requerido por JPA
    }

    public Plataforma(String nombre) {
        this.nombre = nombre;
    }

    // ========================== DESARROLLO METODOS ==========================

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<Juego> getListJuegos() {
        return this.listJuegos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addJuego(Juego juego) {
        this.listJuegos.add(juego);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plataforma)) return false;
        Plataforma other = (Plataforma) o;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
