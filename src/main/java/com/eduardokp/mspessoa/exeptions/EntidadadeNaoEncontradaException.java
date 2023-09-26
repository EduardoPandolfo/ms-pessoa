package com.eduardokp.mspessoa.exeptions;

public class EntidadadeNaoEncontradaException extends IllegalArgumentException {
    public final static String MSG = "Registro de %s não encontrado para código: %s.";

    public EntidadadeNaoEncontradaException(String classe, Long id) {
        super(String.format(MSG, classe, id));
    }
}
