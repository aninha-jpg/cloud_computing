package com.pucpr.cloudcomputing.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "documentacao")
public class Documentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Documentacao(){

    }

    public Documentacao(Matricula matricula, Status status) {
        this.matricula = matricula;
        this.status = status;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
