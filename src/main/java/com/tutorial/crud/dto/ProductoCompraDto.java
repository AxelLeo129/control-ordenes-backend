package com.tutorial.crud.dto;

public class ProductoCompraDto {
    
    private int cantidad;
    private int compra;
    private int producto;
    private double precio;

    public ProductoCompraDto(int cantidad, int compra, int producto, double precio) {
        this.cantidad = cantidad;
        this.compra = compra;
        this.producto = producto;
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
