package com.donuscode.domain.service;

import com.donuscode.domain.entity.ContaBancaria;
import com.donuscode.domain.entity.Transferencia;
import com.donuscode.domain.exception.SaldoInsuficienteException;
import com.donuscode.domain.exception.ValorExcedidoException;
import com.donuscode.domain.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public List<ContaBancaria> transferir(Transferencia trans) {
        Boolean transferido = false;
        Boolean somado;
        List<ContaBancaria> lista = null;

        ContaBancaria contaOrigem = contaBancariaRepository.findByNumeroConta(trans.getContaOrigem());
        ContaBancaria contaDestino = contaBancariaRepository.findByNumeroConta(trans.getContaDestino());


        contaOrigem.setSaldo(contaOrigem.getSaldo() - trans.valorTransferencia);
        contaDestino.setSaldo(contaDestino.getSaldo() + trans.valorTransferencia);
        somado = true;


        if (somado != null)
            transferido = true;

        if (contaOrigem.getSaldo() < 0.0)
            throw new SaldoInsuficienteException(
                    String.format("Saldo insuficiente não é possível relizar essa transferênncia!"));

        if (transferido) {
            contaBancariaRepository.save(contaOrigem);
            contaBancariaRepository.save(contaDestino);
            return contaBancariaRepository.findAll();
        }
        return lista;
    }

    public List<ContaBancaria> depositar(Transferencia trans) {
        Boolean transferido = false;
        Boolean somado;
        List<ContaBancaria> lista = null;

        ContaBancaria contaDestino = contaBancariaRepository.findByNumeroConta(trans.getContaDestino());

        contaDestino.setSaldo(contaDestino.getSaldo() + trans.valorTransferencia);
        somado = true;

        if (somado) {
            transferido = true;
        }

        if (trans.valorTransferencia > 2000.0) {
            throw new ValorExcedidoException(
                    String.format("Não é possível depositar um valor tão alto!"));
        }

        if (transferido) {
            contaBancariaRepository.save(contaDestino);
            return contaBancariaRepository.findAll();
        }
        return lista;
    }
}
