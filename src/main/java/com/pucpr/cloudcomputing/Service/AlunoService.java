package com.pucpr.cloudcomputing.Service;


import com.pucpr.cloudcomputing.Entity.Aluno;
import com.pucpr.cloudcomputing.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public Aluno existsByEmail(String email) {
        Aluno aluno = alunoRepository.findByEmail(email);

        if(aluno != null){
            return aluno;
        }
        return null;
    }

    public Aluno salvar(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Aluno buscaPorID(Long id){
        return alunoRepository.findById(id).orElse(null);
    }
}
