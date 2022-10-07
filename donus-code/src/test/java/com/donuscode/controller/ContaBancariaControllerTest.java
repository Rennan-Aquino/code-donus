package com.donuscode.controller;

import com.donuscode.domain.entity.ContaBancaria;
import com.donuscode.domain.repository.ContaBancariaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ContaBancariaController.class})
class ContaBancariaControllerTest {

    @Autowired
    ContaBancariaController controller;

    @MockBean
    ContaBancariaRepository repository;

    @Test
    void getContaPorId() {
        ContaBancaria contaBancaria = new ContaBancaria();

        when(repository.findById(1L)).thenReturn(Optional.of(contaBancaria));
        ResponseEntity resposta = controller.buscar(1L);

        assertEquals(contaBancaria, resposta.getBody());
    }

    @Test
    void adicionarNovaConta() {
        ContaBancaria contaBancaria = new ContaBancaria();

        when(repository.save(contaBancaria)).thenReturn(contaBancaria);
        ContaBancaria resposta = repository.save(contaBancaria);

        assertEquals(contaBancaria, resposta);
    }

    @Test
    void removerPorId() {
        ContaBancaria contaBancaria = new ContaBancaria();

        when(repository.findById(1L)).thenReturn(Optional.of(contaBancaria));
        ResponseEntity resposta = controller.deletar(1L);

        assertEquals(400, resposta.getStatusCodeValue());
    }

}