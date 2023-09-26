package com.eduardokp.mspessoa.dtos.factory;

import com.eduardokp.mspessoa.dtos.PessoaDTO;
import com.eduardokp.mspessoa.entities.Pessoa;

public class MsPessoaFactory {

    public static PessoaDTO fromEntity(Pessoa pessoa) {
        PessoaDTO dto = new PessoaDTO();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setDataNascimento(pessoa.getDataNascimento());
        return dto;
    }

    /*
        Não realiza o map de endereço
    */
    public static Pessoa fromDTO(PessoaDTO pessoaDTO) {
        Pessoa entity = new Pessoa();
        entity.setId(pessoaDTO.getId());
        entity.setNome(pessoaDTO.getNome());
        entity.setDataNascimento(pessoaDTO.getDataNascimento());
        return entity;
    }
}
