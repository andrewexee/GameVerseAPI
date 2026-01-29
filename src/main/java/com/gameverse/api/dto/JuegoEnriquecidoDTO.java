package com.gameverse.api.dto;

/**
 * Esta clase ...
 *
 * @Autor: Javier Raposo Huelva
 * @Version: 2026:01
 */
public class JuegoEnriquecidoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String portadaUrl;
    private double precio;
    private String nombreCompany;


    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getPortadaUrl() {
        return portadaUrl;
    }
    public void setPortadaUrl(String portadaUrl) {
        this.portadaUrl = portadaUrl;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getNombreCompany() {
        return nombreCompany;
    }
    public void setNombreCompany(String nombreCompany) {
        this.nombreCompany = nombreCompany;
    }
}