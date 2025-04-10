package com.autoclick.demo.config.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarroNaoEncontradoException extends RuntimeException {

    public CarroNaoEncontradoException() {
        super("O carro não foi encontrado");
    }
}
