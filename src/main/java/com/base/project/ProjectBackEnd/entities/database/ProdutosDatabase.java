package com.base.project.ProjectBackEnd.entities.database;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TabelaProdutos")
public class ProdutosDatabase {

    @Id
    @Column(name = "id_produto")
    private String produtoId;
    @Column(name = "preço" )
    private BigDecimal preco;
    @Column(name = "descrição")
    private String descricao;
    @JsonProperty("validade")
    private LocalDate dataValidade;
}
