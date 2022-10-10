package com.base.project.ProjectBackEnd.repository;


import com.base.project.ProjectBackEnd.entities.database.ProdutosDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutosRepository extends JpaRepository<ProdutosDatabase, Integer> {

    Optional<ProdutosDatabase> findByDescricao(String descricao);

}
