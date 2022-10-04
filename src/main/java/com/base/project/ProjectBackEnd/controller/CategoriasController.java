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

    public ResponseEntity<List<CategoriasDTO>> listAll() {
        List<CategoriasDTO> list = catService.listAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriasDTO> findById (@PathVariable Integer id) {
        CategoriasDTO catDTO = catService.findById(id);
        return ResponseEntity.ok().body(catDTO);
    }
    public EnvelopDataJson<CategoriasDTO> insert(@Valid @RequestBody Categorias cat) {
        var response = service.insert(cat);
        return new EnvelopDataJson<CategoriasDTO>();
    }
}
