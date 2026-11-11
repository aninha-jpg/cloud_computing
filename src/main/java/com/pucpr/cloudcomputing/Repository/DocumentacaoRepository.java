package com.pucpr.cloudcomputing.Repository;

import com.pucpr.cloudcomputing.Entity.Documentacao;
import com.pucpr.cloudcomputing.Entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentacaoRepository extends JpaRepository<Documentacao, Long> {
    boolean existsByMatriculaId(Long matriculaId);
    Documentacao findByMatriculaId(Long matriculaId);
}
