package com.pucpr.cloudcomputing.DTO;

import com.pucpr.cloudcomputing.Entity.Matricula;
import com.pucpr.cloudcomputing.Entity.Status;

public record MatriculaDTO(Long id, Long alunoId, Long cursoId, Status status){
    public MatriculaDTO(Matricula matricula) {
        this(
                matricula.getId(),
                matricula.getAluno().getId(),
                matricula.getCurso().getId(),
                matricula.getStatus()
        );
    }
}

