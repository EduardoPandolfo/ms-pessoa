package com.eduardokp.mspessoa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoaid")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "datanascimento", nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private List<PessoaEndereco> enderecos;

    public Pessoa() {

    }

    public Pessoa(Long id) {
        this.id = id;
    }

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

    public List<PessoaEndereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<PessoaEndereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
