package com.pucpr.cloudcomputing.Entity;


import com.pucpr.cloudcomputing.DTO.MatriculaDTO;
import jakarta.persistence.*;

@Table(name = "matricula")
@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Curso curso;
    @Enumerated(EnumType.STRING)
    private Status status;


    public Matricula(){

    }

    public Matricula(Aluno aluno, Curso curso, Status status){
        this.aluno = aluno;
        this.curso = curso;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Curso getCurso() {
        return curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Status getStatus() {
        return status;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
