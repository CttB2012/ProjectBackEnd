package com.base.project.ProjectBackEnd.controller;


import com.base.project.ProjectBackEnd.entities.EnvelopDataJson;
import com.base.project.ProjectBackEnd.entities.Produtos;
import com.base.project.ProjectBackEnd.entities.database.ProdutosDatabase;
import com.base.project.ProjectBackEnd.entities.dto.ProdutosDTO;
import com.base.project.ProjectBackEnd.service.ProdutosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService service;

    @GetMapping
    public ResponseEntity<List<ProdutosDatabase>> listAll() {
        List<ProdutosDatabase> list = service.listAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutosDTO> findById(@PathVariable Integer id) {
        ProdutosDTO prodDTO = service.findById(id);
        return ResponseEntity.ok().body(prodDTO);
    }
    @PostMapping
    public EnvelopDataJson<ProdutosDTO> insert(@Valid @RequestBody Produtos prod) throws Exception {
        var response = service.insert(prod);
        return new EnvelopDataJson<ProdutosDTO>(response);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Produtos> update(@PathVariable Integer id, @Valid @RequestBody Produtos prod) {
        var prodDB = service.update(id, prod);
        return ResponseEntity.ok().body(prodDB);
    }
}
