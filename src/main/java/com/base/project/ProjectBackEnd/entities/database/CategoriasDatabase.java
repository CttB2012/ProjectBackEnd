package com.base.project.ProjectBackEnd.entities.database;

import com.base.project.ProjectBackEnd.entities.Produtos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TesteTabelaCategorias")
public class CategoriasDatabase {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoriaId;
    @Column
    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "categoriasDatabase")
    private List<ProdutosDatabase> produtosList = new ArrayList<>();
}
