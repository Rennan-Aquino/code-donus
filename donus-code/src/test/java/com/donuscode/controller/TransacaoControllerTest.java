package com.donuscode.controller;

import com.donuscode.domain.entity.ContaBancaria;
import com.donuscode.domain.entity.Transferencia;
import com.donuscode.domain.repository.ContaBancariaRepository;
import com.donuscode.domain.service.ContaBancariaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {TransacaoController.class})
class TransacaoControllerTest {

    @Autowired
    TransacaoController controller;

    @MockBean
    private ContaBancariaService service;

    @MockBean
    ContaBancariaRepository repository;

    @Test
    void transferirContaOrigemContaDestino() {
        Transferencia transferencia = new Transferencia();

        when(repository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity resposta = controller.salvar(transferencia);

        assertEquals(202, resposta.getStatusCodeValue());
    }

    @Test
    void depositarContaDestino() {
        Transferencia transferencia = new Transferencia();

        when(repository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity resposta = controller.depositar(transferencia);

        assertEquals(202, resposta.getStatusCodeValue());
    }

}