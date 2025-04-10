package com.autoclick.demo.config.exceptions;

public class DocumentoInvalidoException extends RuntimeException {
    public DocumentoInvalidoException() {
        super("Insira um numero de documento valido");
    }
}