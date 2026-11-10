package com.pucpr.cloudcomputing.Service;

import com.pucpr.cloudcomputing.DTO.DocumentacaoDTO;
import com.pucpr.cloudcomputing.Entity.Documentacao;
import com.pucpr.cloudcomputing.Entity.Matricula;
import com.pucpr.cloudcomputing.Entity.Status;
import com.pucpr.cloudcomputing.Repository.DocumentacaoRepository;
import com.pucpr.cloudcomputing.Repository.MatriculaRepository;
import org.springframework.stereotype.Service;

@Service
public class DocumentacaoService {

    private DocumentacaoRepository repository;
    private MatriculaRepository matriculaRepository;


    public DocumentacaoService(DocumentacaoRepository repository, MatriculaRepository matriculaRepository){
        this.repository = repository;
        this.matriculaRepository = matriculaRepository;
    }

    public boolean existsByMatriculaId(Long id){
        return repository.existsByMatriculaId(id);
    }

    public Documentacao verificarDocumentacao(DocumentacaoDTO data){
        if(repository.existsByMatriculaId(data.matriculaId())){
            return null;
        }

        Matricula matricula = matriculaRepository.findById(data.matriculaId()).orElse(null);

        if(matricula == null){
            return null;
        }

        Status status = Status.PENDENTE;

        if(data.confirmacao().equalsIgnoreCase("OK")){
            status = Status.APROVADA;
        } else {
            status = Status.REPROVADA;
        }

        Documentacao documentacao = new Documentacao(matricula, status);

        return repository.save(documentacao);

    }

}
