package com.eduardokp.mspessoa.exeptions;

public class PessoaEnderecoPrincipalException extends IllegalArgumentException {
    public PessoaEnderecoPrincipalException() {
        super("Já existe um endereço cadastrado como principal para a pessoa.");
    }
}