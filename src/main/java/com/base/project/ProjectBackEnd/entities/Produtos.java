package com.base.project.ProjectBackEnd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer produtoId;
    @JsonProperty("preço")
    private BigDecimal preco;
    @JsonProperty("descrição")
    private String descricao;
    @JsonProperty("validade")
    private LocalDate dataValidade;
}
