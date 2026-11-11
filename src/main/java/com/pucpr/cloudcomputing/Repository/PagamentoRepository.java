package com.pucpr.cloudcomputing.Repository;

import com.pucpr.cloudcomputing.Entity.Matricula;
import com.pucpr.cloudcomputing.Entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    boolean existsByMatriculaId(Long matriculaId);
    Pagamento findByMatriculaId(Long matriculaId);
}
