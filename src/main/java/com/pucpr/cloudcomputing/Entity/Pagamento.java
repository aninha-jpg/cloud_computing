package com.pucpr.cloudcomputing.Entity;


import com.pucpr.cloudcomputing.DTO.PagamentoDTO;
import jakarta.persistence.*;

@Table(name = "pagamento")
@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor;
    @OneToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Pagamento (){

    }

    public Pagamento(double valor, Matricula matricula, Status status){
        this.valor = valor;
        this.matricula = matricula;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}



