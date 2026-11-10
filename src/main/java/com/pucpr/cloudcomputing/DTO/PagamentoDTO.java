package com.pucpr.cloudcomputing.DTO;

import com.pucpr.cloudcomputing.Entity.Matricula;
import com.pucpr.cloudcomputing.Entity.Status;

public record PagamentoDTO (double valor, Matricula matricula, Status status){
}
