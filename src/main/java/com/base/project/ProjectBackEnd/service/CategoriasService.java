package com.base.project.ProjectBackEnd.service;

import com.base.project.ProjectBackEnd.entities.Categorias;
import com.base.project.ProjectBackEnd.entities.database.CategoriasDatabase;
import com.base.project.ProjectBackEnd.entities.database.ProdutosDatabase;
import com.base.project.ProjectBackEnd.entities.dto.CategoriasDTO;
import com.base.project.ProjectBackEnd.entities.dto.ProdutosDTO;
import com.base.project.ProjectBackEnd.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriasService {

    @Autowired
    private CategoriasRepository catRepository;

    public List<CategoriasDTO> listAll() {
        List<CategoriasDTO> listCategorias = new ArrayList<>();
        return listCategorias;
    }
    public CategoriasDTO findById(Integer id) {
        try {
            Optional<CategoriasDatabase> catDB = catRepository.findById(id);
            CategoriasDTO catDTO = new CategoriasDTO();
            return catDTO;
        }catch (EntityNotFoundException e) {
            throw e;
        }
    }
    public CategoriasDTO insert(Categorias categorias) {
        try {
        Optional<CategoriasDatabase> catDB = catRepository.findById(categorias.getCategoriaId());
        if (catDB.isEmpty()) {
            throw new Exception("Erro");
        }
        var categoriasDB = catRepository.save(mapToDB(categorias));
        return mapToDTO(categoriasDB);
    }catch (Exception e) {
        throw e;
        }
    }
    public Categorias update(Integer id, Categorias cat) {
        CategoriasDatabase catDB = catRepository.getOne(id);
        updateData(cat, catDB);
        return catRepository.save(catDB);
    }
    public void delete (Integer id) {
        try {
            catRepository.deleteById(id);
        }catch (EntityNotFoundException e) {
            throw e;
        }
    }

    private void updateData(CategoriasDatabase cat, CategoriasDatabase catDB) {
        cat.setDescricao(catDB.getDescricao());
    }
    public CategoriasDatabase mapToDB(Categorias categorias) {
        CategoriasDatabase catDB = new CategoriasDatabase();
        catDB.setDescricao(categorias.getDescricao());
        return catDB;
    }
    public CategoriasDTO mapToDTO(CategoriasDatabase categoriasDB) {
        CategoriasDTO categoriasDTO = new CategoriasDTO();
        categoriasDTO.setDescricao(categoriasDTO.getDescricao());
        return categoriasDTO;
    }
}


