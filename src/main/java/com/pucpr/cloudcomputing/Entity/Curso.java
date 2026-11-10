package com.pucpr.cloudcomputing.Entity;

import com.pucpr.cloudcomputing.DTO.CursoDTO;
import jakarta.persistence.*;

@Table(name = "cursos")
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    public Curso() {
    }

    public Curso(CursoDTO data){
        this.nome = data.nome();
    }

    public String getNome(){
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
