package com.eduardokp.mspessoa.service;

import com.eduardokp.mspessoa.dtos.PessoaEnderecoDTO;
import com.eduardokp.mspessoa.dtos.factory.MsPessoaEnderecoFactory;
import com.eduardokp.mspessoa.entities.PessoaEndereco;
import com.eduardokp.mspessoa.exeptions.PessoaEnderecoPrincipalException;
import com.eduardokp.mspessoa.repositories.PessoaEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaEnderecoService {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaEnderecoRepository repository;

    public Long create(PessoaEnderecoDTO dto) {
        PessoaEndereco pessoaEndereco = MsPessoaEnderecoFactory.fromDTO(dto);
        validatePessoa(pessoaEndereco.getPessoa().getId());
        if(pessoaEndereco.isPrincipal()) {
            validateEnderecoPrincipalUnico(pessoaEndereco.getPessoa().getId());
        }
        repository.save(pessoaEndereco);
        return pessoaEndereco.getId();
    }

    public List<PessoaEnderecoDTO> findAllByPessoaId(Long pessoaId) {
        validatePessoa(pessoaId);
        return repository.findByPessoaId(pessoaId).stream().map(MsPessoaEnderecoFactory::fromEntity).collect(Collectors.toList());
    }

    private void validatePessoa(Long pessoaId) {
        pessoaService.findById(pessoaId);
    }

    private void validateEnderecoPrincipalUnico(Long pessoaId) {
        if(findAllByPessoaId(pessoaId).stream().anyMatch(PessoaEnderecoDTO::isPrincipal)) {
            throw new PessoaEnderecoPrincipalException();
        }
    }
}
