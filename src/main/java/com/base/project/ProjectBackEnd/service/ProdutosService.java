package com.base.project.ProjectBackEnd.service;

import com.base.project.ProjectBackEnd.entities.Produtos;
import com.base.project.ProjectBackEnd.entities.database.ProdutosDatabase;
import com.base.project.ProjectBackEnd.entities.dto.ProdutosDTO;
import com.base.project.ProjectBackEnd.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public  List<ProdutosDTO> listAll() {
        List<ProdutosDTO> listProdutos = new ArrayList<>();
        return listProdutos;
    }

//    public ProdutosDTO findById(Integer id) {
//        Optional<Produtos> obj = repository.findById();
//    }


    public ProdutosDTO insert(Produtos produtos) {
        //Verificar se o produto existe no Banco de dados
        //Se o produto não existir: salvar no banco de dados e retornar os dados do produto salvo
        //Se o produto existir: lançar exceção
        var produtosDB = repository.save(mapToDB(produtos));
        return mapToDTO(produtosDB);
    }
    public ProdutosDatabase mapToDB(Produtos produtos){      //Assinatura que recebe produtos do tipo Produtos e retorna ProdutosDataBase
        ProdutosDatabase produtosDB = new ProdutosDatabase();//Instanciação da ProdutosDataBase com o nome produtosDB
        produtosDB.setProdutoId(produtos.getProdutoId());    //Recebe ProdutoId como tipo Produtos com o nome produtos e atribui para produtosDB
        return produtosDB;                                   //retorna produtosDB
    }
    public ProdutosDTO mapToDTO(ProdutosDatabase produtosDB){ //Assinatura que produtosDB do tipo ProdutosDataBase e retorna ProdutosDTO
        ProdutosDTO produtosDTO = new ProdutosDTO();//Instanciação da ProdutosDTO com o nome produtosDTO
        produtosDTO.setProdutoId(produtosDB.getProdutoId());//Recebe ProdutoId  como ProdutosDatabase como o nome de produtoDB
        return produtosDTO;//retorna produtosDTO
    }

    public Produtos update(Integer id, Produtos prod) {

        //Verificar se o produto existe no banco de dados
        //Se o produto existe:
        //Atualizar produtos no banco de dados
        //Se o produto não existe:
        //Lançar exceção: Produto não existe na base de dados.


    }

//    public User update(Long id, User obj) {
//        try {
//            User entity = repository.getOne(id);
//            updateData(entity, obj);
//            return repository.save(entity);
//        } catch (EntityNotFoundException e) {
//            throw new ExceptionApiCadastro(HttpStatus.BAD_REQUEST, "CAD-03", e.getMessage());
//        }catch (Exception e) {
//            throw  new ExceptionApiCadastro(HttpStatus.INTERNAL_SERVER_ERROR,"CAD-02", e.getMessage());
//        }
    }

}
