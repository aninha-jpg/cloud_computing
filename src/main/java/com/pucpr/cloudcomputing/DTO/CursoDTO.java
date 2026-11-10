package com.pucpr.cloudcomputing.DTO;

import com.pucpr.cloudcomputing.Entity.Curso;

public record CursoDTO(Long id, String nome){
    public CursoDTO(Curso curso) {
        this(curso.getId(), curso.getNome());
    }
}
