package com.gameverse.api.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrés Iglesias Camacho
 * @date 15.01.2026
 */
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,
            nullable = false)
    private String nombre;


    // Dentro de Company.java

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Juego> listJuegos = new ArrayList<>();

    public Company() {
        // Constructor vacío requerido por JPA
    }

    public Company(String nombre) {
        this.nombre = nombre;
    }

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
        juego.setCompany(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company other = (Company) o;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
