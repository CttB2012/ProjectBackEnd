package com.base.project.ProjectBackEnd.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @Id
    @JsonProperty("id")
    private Integer produtoId;

    @NotNull(message = "O preço é obrigatório")
    @NotBlank(message = "Um preço deve ser inserido")
    @NotEmpty(message = "O campo 'preço' não pode ser vazio")
    @JsonProperty("preço")
    private BigDecimal preco;

    @NotNull(message = "A descrição é obrigatória")
    @NotBlank(message = "Uma descrição deve ser inserida")
    @NotEmpty(message = "O campo 'descrição' não pode ser vazio")
    @JsonProperty("descrição")
    private String descricao;

    @NotNull(message = "A data de validade é obrigatória")
    @NotBlank(message = "Uma data de validade deve ser inserida")
    @NotEmpty(message = "O campo 'data de validade' não pode ser vazio")
    @JsonProperty("validade")
    private LocalDate dataValidade;
}
