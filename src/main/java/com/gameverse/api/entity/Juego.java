package com.gameverse.api.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrés Iglesias Camacho
 * @date 15.01.2026
 */
@Entity
@Table(name = "juego")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,
            nullable = false)
    private String nombre;

    @Column(nullable = true)
    private String descripcion;

    @Column(nullable = false)
    private double precio;

    @ManyToOne
    @JoinColumn(name ="id_company", referencedColumnName = "id")
    private Company company;


    public Juego() {
        // Constructor vacío requerido por JPA
    }


    public Juego(String nombre, String descripcion, double precio, Company company) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.company = company;
    }


    public Juego(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = null;
    }

    public Long getId(){
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public double getPrecio() {
        return this.precio;
    }

    public Long getIdCompany() {
        return this.company.getId();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCompany(Company company) {
        this.company = company;
        if (company != null && !company.getListJuegos().contains(this)) {
            company.getListJuegos().add(this);
        }
    }
}
