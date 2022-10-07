package com.base.project.ProjectBackEnd.entities.database;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TesteTabelaProdutos")
public class ProdutosDatabase {

    @Id
    @Column(name = "id_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer produtoId;
    @Column(name = "preço" )
    private BigDecimal preco;
    @Column(name = "descrição")
    private String descricao;
    @Column(name = "validade")
    private LocalDate dataValidade;
}
