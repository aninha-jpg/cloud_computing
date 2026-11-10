package com.pucpr.cloudcomputing.Service;

import com.pucpr.cloudcomputing.DTO.MatriculaDTO;
import com.pucpr.cloudcomputing.Entity.Aluno;
import com.pucpr.cloudcomputing.Entity.Curso;
import com.pucpr.cloudcomputing.Entity.Matricula;
import com.pucpr.cloudcomputing.Entity.Status;
import com.pucpr.cloudcomputing.Repository.AlunoRepository;
import com.pucpr.cloudcomputing.Repository.CursoRepository;
import com.pucpr.cloudcomputing.Repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    private MatriculaRepository repository;
    private AlunoRepository alunoRepository;
    private CursoRepository cursoRepository;


    @Autowired
    public MatriculaService(MatriculaRepository repository, AlunoRepository alunoRepository, CursoRepository cursoRepository){
        this.repository = repository;
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    public boolean existsByAlunoId(Long alunoId) {
        return repository.existsByAlunoId(alunoId);
    }

    public boolean existsByAlunoIdAndCursoId(Long alunoId, Long cursoId) {
        return repository.existsByAlunoIdAndCursoId(alunoId, cursoId);
    }

    public Matricula findByAlunoId(Long alunoId) {
        return repository.findByAlunoId(alunoId);
    }

    public Matricula salvar(MatriculaDTO data){
        Aluno aluno = alunoRepository.findById(data.alunoId()).orElse(null);
        Curso curso = cursoRepository.findById(data.cursoId()).orElse(null);

        if(aluno == null || curso == null){
            return null;
        }
        Matricula matricula = new Matricula(aluno, curso, Status.PENDENTE);
        return repository.save(matricula);
    }

    public List<Matricula> listarTodas(){
        return repository.findAll();
    }
}

