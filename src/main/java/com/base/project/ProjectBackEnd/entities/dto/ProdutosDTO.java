package com.base.project.ProjectBackEnd.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutosDTO {

    @JsonProperty("id")
    private Integer produtoId;
    @JsonProperty("preço")
    private BigDecimal preco;
    @JsonProperty("descrição")
    private String descricao;
    @JsonProperty("validade")
    private LocalDate dataValidade;
}
