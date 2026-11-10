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

    public Pagamento(PagamentoDTO data){
        this.valor = data.valor();
        this.matricula = data.matricula();
        this.status = data.status();
    }



}



