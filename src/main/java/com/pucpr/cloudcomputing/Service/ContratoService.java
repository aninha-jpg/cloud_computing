package com.pucpr.cloudcomputing.Service;

import com.pucpr.cloudcomputing.DTO.ContratoDTO;
import com.pucpr.cloudcomputing.Entity.*;
import com.pucpr.cloudcomputing.Repository.DocumentacaoRepository;
import com.pucpr.cloudcomputing.Repository.MatriculaRepository;
import com.pucpr.cloudcomputing.Repository.PagamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class ContratoService {

    private MatriculaRepository matriculaRepository;
    private DocumentacaoRepository documentacaoRepository;
    private PagamentoRepository pagamentoRepository;
    private AzureService azureService;

    public ContratoService(MatriculaRepository matriculaRepository, PagamentoRepository pagamentoRepository, DocumentacaoRepository documentacaoRepository, AzureService azureService) {

        this.matriculaRepository = matriculaRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.documentacaoRepository = documentacaoRepository;
        this.azureService = azureService;
    }


    public String criarContrato(ContratoDTO data){
        Pagamento pagamento = pagamentoRepository.findByMatriculaId(data.matriculaId());
        Matricula matricula = matriculaRepository.findById(data.matriculaId()).orElse(null);
        Documentacao documentacao = documentacaoRepository.findByMatriculaId(data.matriculaId());

        if(pagamento == null || documentacao == null || matricula == null) {
            return null;
        }

            if(pagamento.getStatus() == Status.APROVADA && documentacao.getStatus() == Status.APROVADA){
                matricula.setStatus(Status.APROVADA);
                matriculaRepository.save(matricula);

                return azureService.enviarConfirmacao();
            } else {
                return "Não foi possível gerar o contrato, reveja o status do pagamento e da documentação.";
            }
    }
}
