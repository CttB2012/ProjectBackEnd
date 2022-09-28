package com.base.project.ProjectBackEnd.controller;


import com.base.project.ProjectBackEnd.entities.Produtos;
import com.base.project.ProjectBackEnd.entities.dto.ProdutosDTO;
import com.base.project.ProjectBackEnd.service.ProdutosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService service;


    public ResponseEntity<ProdutosDTO> insert(@Valid @RequestBody Produtos prod) {

        var response = service.insert(prod);
        return new ResponseEntity<ProdutosDTO>(response);
    }


}
