package com.pucpr.cloudcomputing.Controller;

import com.pucpr.cloudcomputing.DTO.MatriculaDTO;
import com.pucpr.cloudcomputing.Entity.Matricula;
import com.pucpr.cloudcomputing.Service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    private MatriculaService service;

    public MatriculaController(MatriculaService service){
        this.service = service;
    }

    @PostMapping
    //para salvar passa alunoId e cursoId
    public ResponseEntity<MatriculaDTO> salvarMatricula(@RequestBody MatriculaDTO data){
        Matricula matriculaSalva = service.salvar(data);
        return ResponseEntity.ok(new MatriculaDTO(matriculaSalva));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<MatriculaDTO>> ListarMatriculas(){
        List<MatriculaDTO> matriculas = service.listarTodas()
                .stream()
                .map(MatriculaDTO::new)
                .toList();

        if(matriculas.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(matriculas);
    }
}
