package com.base.project.ProjectBackEnd.service;

import com.base.project.ProjectBackEnd.entities.Produtos;
import com.base.project.ProjectBackEnd.entities.database.ProdutosDatabase;
import com.base.project.ProjectBackEnd.entities.dto.ProdutosDTO;
import com.base.project.ProjectBackEnd.exceptions.DatabaseException;
import com.base.project.ProjectBackEnd.exceptions.ExceptionApiCadastro;
import com.base.project.ProjectBackEnd.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository repository;

    public List<ProdutosDatabase> listAll() {
        List<ProdutosDatabase> listProdutos = repository.findAll();
        return listProdutos;
    }

    public ProdutosDTO findById(Integer id) {
        try {
            ProdutosDatabase obj = repository.findById(id).get();
            ProdutosDTO produtosDTO = new ProdutosDTO();
            produtosDTO.setProdutoId(obj.getProdutoId());
            produtosDTO.setPreco(obj.getPreco());
            produtosDTO.setDescricao(obj.getDescricao());
            produtosDTO.setDataValidade(obj.getDataValidade());
            return produtosDTO;
        } catch (Exception e) {
            throw new ExceptionApiCadastro(HttpStatus.BAD_REQUEST, "CAD-05", e.getMessage());
        }
    }

    public ProdutosDTO insert(Produtos produtos) throws Exception {
        //Verificar se o produto existe no Banco de dados
        //Se o produto não existir: salvar no banco de dados e retornar os dados do produto salvo
        //Se o produto existir: lançar exceção
        try {
            Optional<ProdutosDatabase> prodDB = repository.findByDescricao(produtos.getDescricao());
            if (prodDB.isPresent()) {
                throw new ExceptionApiCadastro(HttpStatus.BAD_REQUEST, "CAD-06");
            }
            var produtosDB = repository.save(mapToDB(produtos));
            return mapToDTO(produtosDB);
        } catch (Exception e) {
            throw new ExceptionApiCadastro(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-07", e.getMessage());
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
            produtosDB.setDescricao(prod.getDescricao());
            produtosDB.setPreco(prod.getPreco());
            produtosDB.setDataValidade(prod.getDataValidade());
            return prod;
        } catch (EmptyResultDataAccessException e) {
            throw new ExceptionApiCadastro(HttpStatus.BAD_REQUEST, "CAD-05", e.getMessage());
        }catch (Exception e) {
            throw new ExceptionApiCadastro(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-09", e.getMessage());
        }
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ExceptionApiCadastro(HttpStatus.BAD_REQUEST, "CAD-05", e.getMessage());
        }catch (Exception e) {
            throw new ExceptionApiCadastro(HttpStatus.INTERNAL_SERVER_ERROR, "CAD-08", e.getMessage());
        }
    }

    private void updateData(Produtos prod, ProdutosDatabase prodDB) {
        prodDB.setPreco(prod.getPreco());
        prodDB.setDescricao(prod.getDescricao());
        prodDB.setDataValidade(prod.getDataValidade());
    }

    public ProdutosDatabase mapToDB(Produtos produtos) {      //Assinatura que recebe produtos do tipo Produtos e retorna ProdutosDataBase
        ProdutosDatabase produtosDB = new ProdutosDatabase();//Instanciação da ProdutosDataBase com o nome produtosDB
        produtosDB.setPreco(produtos.getPreco());            //Recebe ProdutoId como tipo Produtos com o nome produtos e atribui para produtosDB
        produtosDB.setDescricao(produtos.getDescricao());
        produtosDB.setDataValidade(produtos.getDataValidade());
        return produtosDB;                                   //retorna produtosDB
    }

    public ProdutosDTO mapToDTO(ProdutosDatabase produtosDB) { //Assinatura que recebe produtosDB do tipo ProdutosDataBase e retorna ProdutosDTO
        ProdutosDTO produtosDTO = new ProdutosDTO();          //Instanciação da ProdutosDTO com o nome produtosDTO
        produtosDTO.setProdutoId(produtosDB.getProdutoId());  //Recebe ProdutoId  como ProdutosDatabase com o nome de produtoDB
        produtosDTO.setPreco(produtosDB.getPreco());
        produtosDTO.setDescricao(produtosDB.getDescricao());
        produtosDTO.setDataValidade(produtosDB.getDataValidade());
        return produtosDTO;                                   //retorna produtosDTO
    }
}


