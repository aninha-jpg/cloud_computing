package com.pucpr.cloudcomputing.Controller;

import com.pucpr.cloudcomputing.DTO.AlunoDTO;
import com.pucpr.cloudcomputing.DTO.CursoDTO;
import com.pucpr.cloudcomputing.DTO.MatriculaDTO;
import com.pucpr.cloudcomputing.Entity.Aluno;
import com.pucpr.cloudcomputing.Entity.Curso;
import com.pucpr.cloudcomputing.Service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
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
