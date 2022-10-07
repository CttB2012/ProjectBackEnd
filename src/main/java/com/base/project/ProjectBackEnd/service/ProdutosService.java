package com.base.project.ProjectBackEnd.service;

import com.base.project.ProjectBackEnd.entities.Produtos;
import com.base.project.ProjectBackEnd.entities.database.ProdutosDatabase;
import com.base.project.ProjectBackEnd.entities.dto.ProdutosDTO;
import com.base.project.ProjectBackEnd.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository repository;

    public List<ProdutosDTO> listAll() {
        List<ProdutosDTO> listProdutos = new ArrayList<>();
        return listProdutos;
    }

    public ProdutosDTO findById(Integer id) {
        try {
            ProdutosDatabase obj = repository.findById(id).get();
            ProdutosDTO produtosDTO = new ProdutosDTO();
            produtosDTO.setPreco(obj.getPreco());
            produtosDTO.setDescricao(obj.getDescricao());
            produtosDTO.setDataValidade(obj.getDataValidade());
            return produtosDTO;
        } catch (EntityNotFoundException e) {
            throw e;
        }
    }

    public ProdutosDTO insert(Produtos produtos) throws Exception {
        //Verificar se o produto existe no Banco de dados
        //Se o produto não existir: salvar no banco de dados e retornar os dados do produto salvo
        //Se o produto existir: lançar exceção
        try {
            Optional<ProdutosDatabase> prodDB = repository.findById(produtos.getProdutoId());
            if (prodDB.isPresent()) {
                throw new Exception("Erro");
            }
            var produtosDB = repository.save(mapToDB(produtos));
            return mapToDTO(produtosDB);
        } catch (Exception e) {
            throw e;
        }
    }

    public Produtos update(Integer id, Produtos prod) {
        //Verificar se o produto existe no banco de dados
        //Se o produto existe:
        //Atualizar produtos no banco de dados
        //Se o produto não existe:
        //Lançar exceção: Produto não existe na base de dados.
        try {
            ProdutosDatabase produtosDB = repository.findById(id).get();
            updateData(prod, produtosDB);
            var prodDB =  repository.save(produtosDB);
            prod.setDescricao(produtosDB.getDescricao());
            prod.setPreco(produtosDB.getPreco());
            prod.setDataValidade(produtosDB.getDataValidade());
            return prod;
        } catch (EntityNotFoundException e) {
            throw e;
        }
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw e;
        }
    }

    private void updateData(Produtos prod, ProdutosDatabase prodDB) {
        prodDB.setPreco(prod.getPreco());
        prodDB.setDescricao(prod.getDescricao());
        prodDB.setDataValidade(prod.getDataValidade());
    }

    public ProdutosDatabase mapToDB(Produtos produtos) {      //Assinatura que recebe produtos do tipo Produtos e retorna ProdutosDataBase
        ProdutosDatabase produtosDB = new ProdutosDatabase();//Instanciação da ProdutosDataBase com o nome produtosDB
        produtosDB.setProdutoId(produtos.getProdutoId());    //Recebe ProdutoId como tipo Produtos com o nome produtos e atribui para produtosDB
        return produtosDB;                                   //retorna produtosDB
    }

    public ProdutosDTO mapToDTO(ProdutosDatabase produtosDB) { //Assinatura que recebe produtosDB do tipo ProdutosDataBase e retorna ProdutosDTO
        ProdutosDTO produtosDTO = new ProdutosDTO();          //Instanciação da ProdutosDTO com o nome produtosDTO
        produtosDTO.setProdutoId(produtosDB.getProdutoId());  //Recebe ProdutoId  como ProdutosDatabase com o nome de produtoDB
        return produtosDTO;                                   //retorna produtosDTO
    }
}


