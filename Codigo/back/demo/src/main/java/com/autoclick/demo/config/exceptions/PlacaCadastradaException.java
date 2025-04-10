package com.autoclick.demo.config.exceptions;

public class PlacaCadastradaException extends RuntimeException {

    public PlacaCadastradaException() {
        super("Placa já cadastrada");
    }
}
