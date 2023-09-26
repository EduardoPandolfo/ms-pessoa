package com.eduardokp.mspessoa.dtos.factory;

import com.eduardokp.mspessoa.dtos.PessoaEnderecoDTO;
import com.eduardokp.mspessoa.entities.PessoaEndereco;

public class MsPessoaEnderecoFactory {

    public static PessoaEnderecoDTO fromEntity(PessoaEndereco pessoaEndereco) {
        PessoaEnderecoDTO dto = new PessoaEnderecoDTO();
        dto.setId(pessoaEndereco.getId());
        dto.setCep(pessoaEndereco.getCep());
        dto.setCidade(pessoaEndereco.getCidade());
        dto.setNumero(pessoaEndereco.getNumero());
        dto.setLogradouro(pessoaEndereco.getLogradouro());
        dto.setPrincipal(pessoaEndereco.isPrincipal());
        dto.setPessoaDTO(MsPessoaFactory.fromEntity(pessoaEndereco.getPessoa()));

        return dto;
    }

    public static PessoaEndereco fromDTO(PessoaEnderecoDTO pessoaEnderecoDTO) {
        PessoaEndereco entity = new PessoaEndereco();
        entity.setId(pessoaEnderecoDTO.getId());
        entity.setPessoa(MsPessoaFactory.fromDTO(pessoaEnderecoDTO.getPessoaDTO()));
        entity.setCidade(pessoaEnderecoDTO.getCidade());
        entity.setLogradouro(pessoaEnderecoDTO.getLogradouro());
        entity.setCep(pessoaEnderecoDTO.getCep());
        entity.setNumero(pessoaEnderecoDTO.getNumero());
        entity.setLogradouro(pessoaEnderecoDTO.getLogradouro());
        entity.setPrincipal(pessoaEnderecoDTO.isPrincipal());

        return entity;
    }
}
