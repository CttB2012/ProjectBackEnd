package com.base.project.ProjectBackEnd.entities.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TabelaCategorias")
public class CategoriasDatabase {

    @Id
    @Column
    private Integer categoriaId;
    @Column
    private String descricao;
}
