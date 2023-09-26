package com.eduardokp.mspessoa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "pessoaendereco")
public class PessoaEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoaenderecoid")
    private Long id;

    @JsonIgnoreProperties({"addresses"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pessoaid")
    private Pessoa pessoa;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    private String logradouro;

    private String cep;

    private String numero;

    private boolean principal;

    public PessoaEndereco() {

    }

    public PessoaEndereco(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
