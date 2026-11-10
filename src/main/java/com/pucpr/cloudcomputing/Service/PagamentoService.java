package com.pucpr.cloudcomputing.Service;

import com.pucpr.cloudcomputing.Entity.Matricula;
import com.pucpr.cloudcomputing.Entity.Pagamento;
import com.pucpr.cloudcomputing.Repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    private PagamentoRepository repository;

    @Autowired
    public PagamentoService(PagamentoRepository repository){
        this.repository = repository;
    }

    public boolean existsByMatriculaId(Long matriculaId) {
        return repository.existsByMatriculaId(matriculaId);
    }

    public Pagamento salvar(Pagamento pagamento){
        return repository.save(pagamento);
    }

}
