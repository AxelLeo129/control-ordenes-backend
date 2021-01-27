package com.tutorial.crud.controller;

import java.util.List;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.ProductoCompraDto;
import com.tutorial.crud.dto.Promedio;
import com.tutorial.crud.dto.Reporte;
import com.tutorial.crud.dto.Total;
import com.tutorial.crud.entity.ProductoCompra;
import com.tutorial.crud.security.service.UsuarioService;
import com.tutorial.crud.service.CompraService;
import com.tutorial.crud.service.ProductoCompraService;
import com.tutorial.crud.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto_compra")
@CrossOrigin(origins = "*")
public class ProductoCompraController {
    
    @Autowired
    ProductoCompraService productoCompraService;

    @Autowired
    ProductoService productoService;

    @Autowired
    CompraService compraService;

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductoCompraDto productoCompraDto){
        ProductoCompra producto_compra;
        if(productoCompraService.getProductoCompra(productoService.getOne(productoCompraDto.getProducto()).get()).size() > 0) {
            producto_compra = productoCompraService.getProductoCompra(productoService.getOne(productoCompraDto.getProducto()).get()).get(0);
            producto_compra.setCantidad(producto_compra.getCantidad() + productoCompraDto.getCantidad());
            producto_compra.setPrecio(producto_compra.getPrecio() + productoCompraDto.getPrecio());
        }
        else
            producto_compra = new ProductoCompra(productoService.getOne(productoCompraDto.getProducto()).get(), productoCompraDto.getCantidad(), compraService.getOne(productoCompraDto.getCompra()).get(), productoCompraDto.getPrecio());
        productoCompraService.save(producto_compra);
        return new ResponseEntity<>(new Mensaje("datos almacendados correctamente"), HttpStatus.OK);
    }

    @GetMapping("/reports/{id}")
    public ResponseEntity<Reporte> getById(@PathVariable("id") int id){ 
        List<Reporte> productos = productoCompraService.generateReports(usuarioService.getOne(id).get());
        return new ResponseEntity(productoCompraService.generateReports(usuarioService.getOne(id).get()), HttpStatus.OK);
    }

    @GetMapping("/total/{id}")
    public ResponseEntity<Total> getTotal(@PathVariable("id") int id){ 
        Total total = productoCompraService.getTotal(usuarioService.getOne(id).get());
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    @GetMapping("/promedio/{id}")
    public ResponseEntity<Promedio> getMean(@PathVariable("id") int id){ 
        Promedio promedio = productoCompraService.getMean(usuarioService.getOne(id).get());
        return new ResponseEntity<>(promedio, HttpStatus.OK);
    }

}
