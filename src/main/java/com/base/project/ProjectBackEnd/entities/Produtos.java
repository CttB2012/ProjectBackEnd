package com.base.project.ProjectBackEnd.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Produtos {

    @JsonProperty("id")
    private Integer produtoId;

    @NotNull(message = "O preço é obrigatório")
    @JsonProperty("preco")
    private BigDecimal preco;

    @NotNull(message = "A descrição é obrigatória")
    @NotBlank(message = "Uma descrição deve ser inserida")
    @NotEmpty(message = "O campo 'descrição' não pode ser vazio")
    @JsonProperty("descricao")
    private String descricao;

    @NotNull(message = "A data de validade é obrigatória")
    @JsonProperty("validade")
    private LocalDate dataValidade;


    @NotNull
    @JsonProperty("categoria")
    private Categorias categorias;


}
