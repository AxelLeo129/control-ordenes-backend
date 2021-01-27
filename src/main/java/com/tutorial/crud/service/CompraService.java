package com.tutorial.crud.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.tutorial.crud.entity.Compra;
import com.tutorial.crud.repository.CompraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CompraService {
    
    @Autowired
    CompraRepository compraRepository;

    public Optional<Compra> getOne(int id){
        return compraRepository.findById(id);
    }

    public void save(Compra compra){
        compraRepository.save(compra);
    }    

}
