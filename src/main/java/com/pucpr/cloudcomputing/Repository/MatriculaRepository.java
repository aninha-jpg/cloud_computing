package com.pucpr.cloudcomputing.Repository;

import com.pucpr.cloudcomputing.Entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    Matricula findByAlunoId(Long alunoId);
    boolean existsByAlunoId(Long alunoId);
    boolean existsByAlunoIdAndCursoId(Long alunoId, Long cursoId);
}
