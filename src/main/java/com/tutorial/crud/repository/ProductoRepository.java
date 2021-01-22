package com.tutorial.crud.repository;

import com.tutorial.crud.entity.Producto;
import com.tutorial.crud.security.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Optional<Producto> findByNombre(String nombre);
    List<Producto> findByVendedor(Usuario vendedor);
    boolean existsByNombre(String nombre);
}
