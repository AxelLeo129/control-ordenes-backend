package com.tutorial.crud.service;

import java.util.List;

import javax.transaction.Transactional;

import com.tutorial.crud.dto.Promedio;
import com.tutorial.crud.dto.Reporte;
import com.tutorial.crud.dto.Total;
import com.tutorial.crud.entity.Producto;
import com.tutorial.crud.entity.ProductoCompra;
import com.tutorial.crud.repository.ProductoCompraRepository;
import com.tutorial.crud.security.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ProductoCompraService {
    
    @Autowired
    ProductoCompraRepository productoCompraRepository;

    public List<Reporte> generateReports(Usuario vendedor) {
        return productoCompraRepository.generateReports(vendedor);
    }

    public List<ProductoCompra> getProductoCompra(Producto producto) {
        return productoCompraRepository.getProductoCompra(producto);
    }

    public void save(ProductoCompra productoCompra){
        productoCompraRepository.save(productoCompra);
    }

    public Total getTotal(Usuario vendedor) {
        return productoCompraRepository.getTotal(vendedor);
    }

    public Promedio getMean(Usuario vendedor) {
        return productoCompraRepository.getMean(vendedor);
    }

}
