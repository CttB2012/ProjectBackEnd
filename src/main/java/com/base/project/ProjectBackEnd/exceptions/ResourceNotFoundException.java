package com.base.project.ProjectBackEnd.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1l;

    public ResourceNotFoundException(Object id) {
        super("Não encontrado. ID" + id);
    }
}
