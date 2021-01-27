package com.tutorial.crud.controller;

import com.tutorial.crud.dto.CompraDto;
import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.entity.Compra;
import com.tutorial.crud.service.CompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;

@RestController
@RequestMapping("/compra")
@CrossOrigin(origins = "*")
public class CompraController {
    
    @Autowired
    CompraService compraService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CompraDto compraDto){
        if(StringUtils.isBlank(compraDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        Compra compra = new Compra(compraDto.getNombre(), compraDto.getTotal());
        compraService.save(compra);
        return new ResponseEntity<>(new Mensaje("Compra almacenda: id->" + compra.getId()), HttpStatus.OK);
    }

}
