package com.pucpr.cloudcomputing.Repository;

import com.pucpr.cloudcomputing.Entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findByEmail(String email);
    boolean existsByEmail(String email);
}
