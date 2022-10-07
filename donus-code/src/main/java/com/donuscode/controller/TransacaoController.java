package com.donuscode.controller;

import com.donuscode.domain.entity.ContaBancaria;
import com.donuscode.domain.entity.Transferencia;
import com.donuscode.domain.exception.SaldoInsuficienteException;
import com.donuscode.domain.repository.ContaBancariaRepository;
import com.donuscode.domain.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {

    @Autowired
    private ContaBancariaService cbService;

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Transferencia transf) {
        List<ContaBancaria> lista = cbService.transferir(transf);
        return new ResponseEntity<>(lista, ACCEPTED);
    }

    @PostMapping("/deposito")
    public ResponseEntity<?> depositar(@RequestBody Transferencia transf) {
        try {
            List<ContaBancaria> lista = cbService.depositar(transf);
            return new ResponseEntity<>(lista, ACCEPTED);
        } catch (SaldoInsuficienteException e) {
            return ResponseEntity.status(NOT_FOUND).body(e.getMessage());
        }

    }
}