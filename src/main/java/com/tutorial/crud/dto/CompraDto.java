package com.tutorial.crud.dto;

import javax.validation.constraints.NotBlank;

public class CompraDto {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private double total;

    public CompraDto() {
    }

    public CompraDto(@NotBlank String nombre, @NotBlank double total) {
        this.nombre = nombre;
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
