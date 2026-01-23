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

    // Dentro de Juego.java

    @ManyToMany // Un juego tiene muchas categorías, y una categoría muchos juegos
    @JoinTable(
            name = "juego_categoria",
            joinColumns = @JoinColumn(name = "juego_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @Column(nullable = false)
    private List<Categoria> listCategorias;

    @ManyToMany // Lo mismo para plataformas
    @JoinTable(
            name = "juego_plataforma",
            joinColumns = @JoinColumn(name = "juego_id"),
            inverseJoinColumns = @JoinColumn(name = "plataforma_id")
    )
    @Column(nullable = false)
    private List<Plataforma> listPlataformas;


    public Juego() { /* Hermano, constructo void */ }


    public Juego(String nombre, String descripcion, double precio, List<Categoria> listCategorias, List<Plataforma> listPlataformas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.listCategorias = listCategorias;
        this.listPlataformas = listPlataformas;
    }


    public Juego(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
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

    public List getListCategorias() {
        return this.listCategorias;
    }

    public List getListPlataformas() {
        return this.listPlataformas;
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

    public void setListCategorias(Categoria categoria) {
        this.listCategorias.add(categoria);
    }

    public void setListPlataformas(Plataforma plataforma) {
        this.listPlataformas.add(plataforma);
    }
}
