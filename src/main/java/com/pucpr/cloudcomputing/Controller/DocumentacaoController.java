package com.pucpr.cloudcomputing.Controller;
import com.pucpr.cloudcomputing.DTO.DocumentacaoDTO;
import com.pucpr.cloudcomputing.DTO.MatriculaDTO;
import com.pucpr.cloudcomputing.Entity.Documentacao;
import com.pucpr.cloudcomputing.Service.DocumentacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://liberacaocredito-emdqguf3bkgzesfp.brazilsouth-01.azurewebsites.net")
@RestController
@RequestMapping("/documentacao")
public class DocumentacaoController {

    private DocumentacaoService service;

    public DocumentacaoController(DocumentacaoService service){
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Documentacao> verificarDocumentacao(@RequestBody DocumentacaoDTO data){
        Documentacao documentacao = service.verificarDocumentacao(data);

        if (documentacao == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(documentacao);
    }
}

