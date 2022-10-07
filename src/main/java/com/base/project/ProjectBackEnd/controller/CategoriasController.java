package com.base.project.ProjectBackEnd.controller;


import com.base.project.ProjectBackEnd.entities.Categorias;
import com.base.project.ProjectBackEnd.entities.EnvelopDataJson;
import com.base.project.ProjectBackEnd.entities.dto.CategoriasDTO;
import com.base.project.ProjectBackEnd.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService catService;

    @GetMapping
    public ResponseEntity<List<CategoriasDTO>> listAll() {
        List<CategoriasDTO> list = catService.listAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriasDTO> findById(@PathVariable Integer id) {
        CategoriasDTO catDTO = catService.findById(id);
        return ResponseEntity.ok().body(catDTO);
    }

    @PostMapping
    public EnvelopDataJson<CategoriasDTO> insert(@Valid @RequestBody Categorias cat) throws Exception {
        var response = catService.insert(cat);
        return new EnvelopDataJson<CategoriasDTO>(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        catService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Categorias> update(@PathVariable Integer id, @Valid @RequestBody Categorias cat) {
        cat = catService.update(id, cat);
        return ResponseEntity.ok().body(cat);
    }
}
