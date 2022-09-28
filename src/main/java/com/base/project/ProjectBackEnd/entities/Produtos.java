package com.base.project.ProjectBackEnd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class Produtos {

    @JsonProperty("id")
    private Integer produtoId;
    @JsonProperty("preço")
    private BigDecimal preço;
    @JsonProperty("descrição")
    private String descricao;

}
