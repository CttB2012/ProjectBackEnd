package com.base.project.ProjectBackEnd.service;

import com.base.project.ProjectBackEnd.entities.Categorias;
import com.base.project.ProjectBackEnd.entities.database.CategoriasDatabase;
import com.base.project.ProjectBackEnd.entities.dto.CategoriasDTO;
import com.base.project.ProjectBackEnd.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository catRepository;

    public List<CategoriasDatabase> listAll() {
        List<CategoriasDatabase> listCatDB = catRepository.findAll();
        return listCatDB;
    }

    public CategoriasDTO findById(Integer id) {
        try {
            CategoriasDatabase catDB = catRepository.findById(id).get();
            CategoriasDTO catDTO = new CategoriasDTO();
            catDTO.setDescricao(catDB.getDescricao());
            catDTO.setCategoriaId(catDB.getCategoriaId());
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
        CategoriasDatabase catDB = catRepository.findById(id).get();
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
        catDB.setDescricao(cat.getDescricao());
       // catDB.setCategoriaId(cat.getCategoriaId());
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


//    List<CategoriasDTO> listCategorias = new ArrayList<>();
//        for (CategoriasDatabase obj : listCatDB ) {
//                CategoriasDTO categoriasDTO = new CategoriasDTO();
//                categoriasDTO.setDescricao(obj.getDescricao());
//                categoriasDTO.setCategoriaId(obj.getCategoriaId());
//                }