package com.pucpr.cloudcomputing.Entity;

import com.pucpr.cloudcomputing.DTO.AlunoDTO;
import jakarta.persistence.*;

@Table(name = "aluno")
@Entity
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;


    public Aluno(){

    }
    public Aluno(AlunoDTO data) {
        this.nome = data.nome();
        this.email = data.email();
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
