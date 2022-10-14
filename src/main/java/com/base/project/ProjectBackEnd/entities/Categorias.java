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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Categorias {


    @JsonProperty("id")
    private Integer categoriaId;

    @NotNull(message = "A descrição é obrigatória")
    @NotBlank(message = "Uma descrição deve ser inserida")
    @NotEmpty(message = "O campo 'descrição' não pode ser vazio")
    @JsonProperty("descricao")
    private String descricao;

}
