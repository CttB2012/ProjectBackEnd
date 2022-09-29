package com.base.project.ProjectBackEnd.service;

import com.base.project.ProjectBackEnd.entities.Produtos;
import com.base.project.ProjectBackEnd.entities.database.ProdutosDatabase;
import com.base.project.ProjectBackEnd.entities.dto.ProdutosDTO;
import com.base.project.ProjectBackEnd.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository repository;

    public ProdutosDTO insert(Produtos produtos) {

        ProdutosDatabase produtosDB = mapToDatabase(produtos);

        var responseDB = repository.save(produtosDB);
        var response = mapToResponse(responseDB);
        return response;

    }

    private ProdutosDTO mapToResponse(ProdutosDatabase produtosDatabase) {
        ProdutosDTO produtosDTO = new ProdutosDTO();
        produtosDTO.setPreco(produtosDatabase.getPreco());
        produtosDTO.setDescricao(produtosDatabase.getDescricao());

        return produtosDTO;
    }
    private ProdutosDatabase mapToDatabase(Produtos produtos) {
        ProdutosDatabase produtosDatabase = new ProdutosDatabase();

        produtosDatabase.setPreco(produtos.getPreco());
        produtosDatabase.setDescricao(produtos.getDescricao());

        return produtosDatabase;

    }

}
