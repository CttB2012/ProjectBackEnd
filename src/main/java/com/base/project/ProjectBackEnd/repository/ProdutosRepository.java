package com.base.project.ProjectBackEnd.repository;

import com.base.project.ProjectBackEnd.entities.database.ProdutosDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<ProdutosDatabase, Integer> {

}
