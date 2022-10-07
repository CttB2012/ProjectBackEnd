package com.base.project.ProjectBackEnd.service;

import com.base.project.ProjectBackEnd.entities.Categorias;
import com.base.project.ProjectBackEnd.entities.database.CategoriasDatabase;
import com.base.project.ProjectBackEnd.entities.database.ProdutosDatabase;
import com.base.project.ProjectBackEnd.entities.dto.CategoriasDTO;
import com.base.project.ProjectBackEnd.entities.dto.ProdutosDTO;
import com.base.project.ProjectBackEnd.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository catRepository;

    public List<CategoriasDTO> listAll() {
        List<CategoriasDTO> listCategorias = new ArrayList<>();
        return listCategorias;
    }

    public CategoriasDTO findById(Integer id) {
        try {
            CategoriasDatabase catDB = catRepository.findById(id).get();
            CategoriasDTO catDTO = new CategoriasDTO();
            catDTO.setDescricao(catDB.getDescricao());
            return catDTO;
        } catch (EntityNotFoundException e) {
            throw e;
        }
    }

    public CategoriasDTO insert(Categorias categorias) throws Exception {
        try {
            Optional<CategoriasDatabase> catDB = catRepository.findByDescricao(categorias.getDescricao());
            if (catDB.isPresent()) {
                throw new Exception("Erro");
            }
            var categoriasDB = catRepository.save(mapToDB(categorias));
            return mapToDTO(categoriasDB);

        } catch (Exception e) {
        throw e;

        }
    }

    public Categorias update(Integer id, Categorias cat) {
        CategoriasDatabase catDB = catRepository.getOne(id);
        updateData(cat, catDB);
        catRepository.save(catDB);
        return cat;
    }

    public void delete(Integer id) {
        try {
            catRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw e;
        }
    }

    private void updateData(Categorias cat, CategoriasDatabase catDB) {
        cat.setDescricao(catDB.getDescricao());
    }

    public CategoriasDatabase mapToDB(Categorias categorias) {
        CategoriasDatabase catDB = new CategoriasDatabase();
        catDB.setDescricao(categorias.getDescricao());
        return catDB;
    }

    public CategoriasDTO mapToDTO(CategoriasDatabase categoriasDB) {
        CategoriasDTO categoriasDTO = new CategoriasDTO();
        categoriasDTO.setDescricao(categoriasDB.getDescricao());
        categoriasDTO.setCategoriaId(categoriasDB.getCategoriaId());
        return categoriasDTO;
    }

}


