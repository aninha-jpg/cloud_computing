package com.pucpr.cloudcomputing.Repository;

import com.pucpr.cloudcomputing.Entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNome(String nome);
}
