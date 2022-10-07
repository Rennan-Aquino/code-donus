package com.donuscode.domain.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(BAD_REQUEST)
public class ValorExcedidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValorExcedidoException(String mensagem) {
        super(mensagem);
    }
}
