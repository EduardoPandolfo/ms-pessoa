package com.eduardokp.mspessoa.dtos;

import javax.validation.constraints.NotBlank;

public class PessoaEnderecoDTO {

    private Long id;
    private PessoaDTO pessoaDTO;

    @NotBlank(message = "cidade é obrigatório")
    private String cidade;
    private String logradouro;
    private String cep;
    private String numero;
    private boolean principal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PessoaDTO getPessoaDTO() {
        return pessoaDTO;
    }

    public void setPessoaDTO(PessoaDTO pessoaDTO) {
        this.pessoaDTO = pessoaDTO;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
}
