package com.pucpr.cloudcomputing.Controller;


import com.pucpr.cloudcomputing.DTO.ContratoDTO;
import com.pucpr.cloudcomputing.DTO.DocumentacaoDTO;
import com.pucpr.cloudcomputing.Entity.Contrato;
import com.pucpr.cloudcomputing.Entity.Documentacao;
import com.pucpr.cloudcomputing.Service.ContratoService;
import com.pucpr.cloudcomputing.Service.DocumentacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/contrato")
public class ContratoController {

    private ContratoService service;

    public ContratoController(ContratoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> criarContrato(@RequestBody ContratoDTO data){
        String contrato = service.criarContrato(data);

        if (contrato == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(contrato);
    }
}
