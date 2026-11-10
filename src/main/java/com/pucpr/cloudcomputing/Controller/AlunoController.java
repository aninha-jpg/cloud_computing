package com.pucpr.cloudcomputing.Controller;


import com.pucpr.cloudcomputing.DTO.AlunoDTO;
import com.pucpr.cloudcomputing.Entity.Aluno;
import com.pucpr.cloudcomputing.Service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService service;

    public AlunoController(AlunoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> salvarAluno(@RequestBody AlunoDTO data){
        Aluno alunoData = new Aluno(data);
        Aluno alunoSalvo = service.salvar(alunoData);

        return ResponseEntity.ok(new AlunoDTO(alunoSalvo.getId(), alunoSalvo.getNome(), alunoSalvo.getEmail()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getMe(@PathVariable Long id){
        Aluno aluno = service.buscaPorID(id);
        if(aluno != null){
            return ResponseEntity.ok(new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getEmail()));
        }
        return ResponseEntity.notFound().build();
    }



}
