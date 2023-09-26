package com.eduardokp.mspessoa.controller.application;

import com.eduardokp.mspessoa.exeptions.EntidadadeNaoEncontradaException;
import com.eduardokp.mspessoa.exeptions.PessoaEnderecoPrincipalException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationAdviceController {

    @ExceptionHandler(EntidadadeNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlerEntidadeNaoEncontrada(EntidadadeNaoEncontradaException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(PessoaEnderecoPrincipalException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerEnderecoPrincipalDuplicado(PessoaEnderecoPrincipalException ex) {
        return ex.getMessage();
    }
}
