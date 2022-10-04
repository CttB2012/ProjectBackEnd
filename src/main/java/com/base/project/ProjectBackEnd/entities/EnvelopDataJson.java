package com.base.project.ProjectBackEnd.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnvelopDataJson<T> {

    @JsonProperty("id")
    private Integer produtoId;
    @JsonProperty("preço")
    private BigDecimal preco;
    @JsonProperty("descrição")
    private String descricao;
    @JsonProperty("validade")
    private T dataValidade;


}
