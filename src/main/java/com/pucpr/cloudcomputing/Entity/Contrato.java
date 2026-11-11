package com.pucpr.cloudcomputing.Entity;


import jakarta.persistence.*;


public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;


    public Contrato() {
    }
    public Contrato(Matricula matricula) {
        this.matricula = matricula;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public Long getId() {
        return id;
    }

}
