package com.pucpr.cloudcomputing.Controller;


import com.pucpr.cloudcomputing.DTO.ContratoDTO;
import com.pucpr.cloudcomputing.Service.ContratoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://liberacaocredito-emdqguf3bkgzesfp.brazilsouth-01.azurewebsites.net")
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
        if (contrato.startsWith("Não foi possível")) {
            return ResponseEntity.badRequest().body(contrato);
        }
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(contrato);
    }
}
