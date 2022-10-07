package com.donuscode.domain.entity;

import lombok.Data;

@Data
public class Transferencia {
    public String contaOrigem;
    public Double valorTransferencia;
    public String contaDestino;
}
