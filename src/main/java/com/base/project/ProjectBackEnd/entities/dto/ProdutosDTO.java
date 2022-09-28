package com.base.project.ProjectBackEnd.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ProdutosDTO {

    @JsonProperty("id")
    private Integer produtoId;
    @JsonProperty("preço")
    private BigDecimal preço;
    @JsonProperty("descrição")
    private String descricao;


}
