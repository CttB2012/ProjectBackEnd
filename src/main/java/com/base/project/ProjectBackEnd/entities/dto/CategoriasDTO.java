package com.base.project.ProjectBackEnd.entities.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriasDTO {

    @JsonProperty("id")
    private Integer categoriaId;
    @JsonProperty("descricao")
    private String descricao;
}
