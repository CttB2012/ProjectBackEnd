package com.base.project.ProjectBackEnd.repository;

import com.base.project.ProjectBackEnd.entities.database.CategoriasDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriasRepository extends JpaRepository<CategoriasDatabase, Integer>{

    Optional<CategoriasDatabase> findByDescricao (String descricao );

}
