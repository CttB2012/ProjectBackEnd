package com.base.project.ProjectBackEnd.entities.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;



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


}
