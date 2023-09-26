package com.eduardokp.mspessoa.dtos;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

public class PessoaDTO {

    private Long id;
    @NotBlank(message = "nome é obrigatório")
    private String nome;
    private LocalDate dataNascimento;

    private List<PessoaEnderecoDTO> enderecos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<PessoaEnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<PessoaEnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }
}
