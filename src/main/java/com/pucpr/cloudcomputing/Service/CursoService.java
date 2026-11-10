package com.pucpr.cloudcomputing.Service;

import com.pucpr.cloudcomputing.Entity.Curso;
import com.pucpr.cloudcomputing.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private CursoRepository repository;

    @Autowired
    public CursoService(CursoRepository repository){
        this.repository = repository;
    }


    public List<Curso> listarCursos(){
        return repository.findAll();
    }

    public Curso findByNome(String nome){
        return repository.findByNome(nome);
    }

    public Curso buscaPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Curso salvar(Curso curso){
        return repository.save(curso);
    }
}

