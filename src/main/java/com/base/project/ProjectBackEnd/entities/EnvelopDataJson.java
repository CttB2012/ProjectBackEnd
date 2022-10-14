package com.base.project.ProjectBackEnd.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnvelopDataJson<T> {

    @JsonProperty("data")
    private T data;

}
