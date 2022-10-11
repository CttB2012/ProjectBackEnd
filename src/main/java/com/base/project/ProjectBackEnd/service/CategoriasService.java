package com.base.project.ProjectBackEnd.service;

import com.base.project.ProjectBackEnd.entities.Categorias;
import com.base.project.ProjectBackEnd.entities.database.CategoriasDatabase;
import com.base.project.ProjectBackEnd.entities.dto.CategoriasDTO;
import com.base.project.ProjectBackEnd.exceptions.DatabaseException;
import com.base.project.ProjectBackEnd.exceptions.ExceptionApiCadastro;
import com.base.project.ProjectBackEnd.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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
        } catch (Exception e) {
            throw new ExceptionApiCadastro(HttpStatus.BAD_REQUEST, "CAD-01", e.getMessage());
        }
    }

    public CategoriasDTO insert(Categorias categorias) throws Exception {
        try {
            Optional<CategoriasDatabase> catDB = catRepository.findByDescricao(categorias.getDescricao());
            if (catDB.isPresent()) {
                throw new ExceptionApiCadastro(HttpStatus.BAD_REQUEST, "CAD-02");
            }
            var categoriasDB = catRepository.save(mapToDB(categorias));
            return mapToDTO(categoriasDB);
        } catch (Exception e) {
            throw new ExceptionApiCadastro(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-03", e.getMessage());
        }
    }

    public Categorias update(Integer id, Categorias cat) {
        try {
            CategoriasDatabase catDB = catRepository.findById(id).get();
            updateData(cat, catDB);
            catRepository.save(catDB);
            return cat;
        }catch (EntityNotFoundException e) {
            throw new ExceptionApiCadastro(HttpStatus.BAD_REQUEST, "CAD-01", e.getMessage());
        }catch (Exception e) {
            throw new ExceptionApiCadastro(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-03", e.getMessage());
        }
    }

    public void delete(Integer id) {
        try {
            catRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new ExceptionApiCadastro(HttpStatus.BAD_REQUEST, "CAD-01", e.getMessage());
        }catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
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
