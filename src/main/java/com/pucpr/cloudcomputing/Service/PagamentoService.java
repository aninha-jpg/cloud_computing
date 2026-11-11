package com.pucpr.cloudcomputing.Service;

import com.pucpr.cloudcomputing.DTO.PagamentoDTO;
import com.pucpr.cloudcomputing.Entity.Matricula;
import com.pucpr.cloudcomputing.Entity.Pagamento;
import com.pucpr.cloudcomputing.Entity.Status;
import com.pucpr.cloudcomputing.Repository.MatriculaRepository;
import com.pucpr.cloudcomputing.Repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    private PagamentoRepository repository;
    private MatriculaRepository matriculaRepository;

    @Autowired
    public PagamentoService(PagamentoRepository repository, MatriculaRepository matriculaRepository){
        this.repository = repository;
        this.matriculaRepository = matriculaRepository;
    }

    public boolean existsByMatriculaId(Long matriculaId) {
        return repository.existsByMatriculaId(matriculaId);
    }

    public Pagamento findByMatriculaId(Long matriculaId) {
        return repository.findByMatriculaId(matriculaId);
    }

    public Pagamento verificarPagamento(PagamentoDTO data){
        if(repository.existsByMatriculaId(data.matriculaId())){
            return null;
        }

        Matricula matricula = matriculaRepository.findById(data.matriculaId()).orElse(null);

        if(matricula == null){
            return null;
        }

        Status status = Status.PENDENTE;

        if(data.confirmacao().equalsIgnoreCase("OK")) {
            status = status.APROVADA;
        } else {
            status = Status.REPROVADA;
        }

        Pagamento pagamento = new Pagamento(data.valor(), matricula, status);
        return repository.save(pagamento);
    }

}
