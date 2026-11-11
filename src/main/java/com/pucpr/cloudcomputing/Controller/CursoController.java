package com.pucpr.cloudcomputing.Controller;


import com.pucpr.cloudcomputing.DTO.CursoDTO;
import com.pucpr.cloudcomputing.Entity.Curso;
import com.pucpr.cloudcomputing.Service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/curso")
public class CursoController {

    private CursoService service;

    public CursoController(CursoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CursoDTO> salvarAluno(@RequestBody CursoDTO data){
        Curso cursoData = new Curso(data);
        Curso cursoSalvo =  service.salvar(cursoData);

        return ResponseEntity.ok(new CursoDTO(cursoSalvo.getId(), cursoSalvo.getNome()));
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> ListarCursos(){
        List<CursoDTO> cursos = service.listarCursos()
                .stream()
                .map(CursoDTO::new)
                .toList();

        if(cursos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cursos);
    }



}
