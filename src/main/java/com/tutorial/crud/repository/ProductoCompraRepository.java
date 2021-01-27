package com.tutorial.crud.repository;

import java.util.List;

import com.tutorial.crud.dto.Promedio;
import com.tutorial.crud.dto.Reporte;
import com.tutorial.crud.dto.Total;
import com.tutorial.crud.entity.Producto;
import com.tutorial.crud.entity.ProductoCompra;
import com.tutorial.crud.security.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCompraRepository extends JpaRepository<ProductoCompra, Integer> {
    
    @Query(value = "SELECT producto.nombre, producto_compra.precio, producto_compra.cantidad FROM producto INNER JOIN producto_compra ON producto_compra.producto=producto.id WHERE producto.vendedor = ?", nativeQuery = true)
    List<Reporte> generateReports(Usuario vendedor);

    @Query(value = "SELECT * FROM producto_compra WHERE producto = ?", nativeQuery = true)
    List<ProductoCompra> getProductoCompra(Producto producto);

    @Query(value = "SELECT SUM(producto_compra.precio) AS total FROM producto INNER JOIN producto_compra ON producto_compra.producto=producto.id WHERE producto.vendedor = ?", nativeQuery = true)
    Total getTotal(Usuario vendedor);

    @Query(value = "SELECT SUM(precio)/COUNT(*) AS mean FROM producto WHERE vendedor = ?", nativeQuery = true)
    Promedio getMean(Usuario vendedor);

}
