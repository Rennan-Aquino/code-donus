package com.donuscode.controller;

import com.donuscode.domain.entity.ContaBancaria;
import com.donuscode.domain.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/contas")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    @GetMapping("/{clienteId}")
    public ResponseEntity<ContaBancaria> buscar(@PathVariable Long clienteId) {
        Optional<ContaBancaria> conta = contaBancariaRepository.findById(clienteId);

        if (conta != null) {
            return ResponseEntity.ok(conta.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ContaBancaria adicionar(@RequestBody ContaBancaria contaBancaria) {
        return contaBancariaRepository.save(contaBancaria);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity deletar(@PathVariable Long clienteId) {
        if (contaBancariaRepository.existsById(clienteId)) {
            contaBancariaRepository.deleteById(clienteId);
            return new ResponseEntity<>(OK);
        }
        return new ResponseEntity<>(BAD_REQUEST);
    }

}