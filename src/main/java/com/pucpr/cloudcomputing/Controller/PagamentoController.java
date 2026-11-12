package com.pucpr.cloudcomputing.Controller;

import com.pucpr.cloudcomputing.DTO.PagamentoDTO;
import com.pucpr.cloudcomputing.Entity.Pagamento;
import com.pucpr.cloudcomputing.Service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "https://liberacaocredito-emdqguf3bkgzesfp.brazilsouth-01.azurewebsites.net")
@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private PagamentoService service;

    public PagamentoController(PagamentoService service){
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Pagamento> verificarPagamento(@RequestBody PagamentoDTO data){
        Pagamento pagamento = service.verificarPagamento(data);

        if (pagamento == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(pagamento);
    }
}
