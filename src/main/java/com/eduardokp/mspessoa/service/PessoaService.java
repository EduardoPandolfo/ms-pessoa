package com.eduardokp.mspessoa.service;

import com.eduardokp.mspessoa.dtos.PessoaDTO;
import com.eduardokp.mspessoa.dtos.factory.MsPessoaFactory;
import com.eduardokp.mspessoa.entities.Pessoa;
import com.eduardokp.mspessoa.exeptions.EntidadadeNaoEncontradaException;
import com.eduardokp.mspessoa.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Long create(PessoaDTO dto) {
        Pessoa pessoa = MsPessoaFactory.fromDTO(dto);
        repository.save(pessoa);
        return pessoa.getId();
    }

    public void update(Long id, PessoaDTO dto) {
        findById(id);
        Pessoa pessoa = MsPessoaFactory.fromDTO(dto);
        pessoa.setId(id);
        repository.save(pessoa);
    }

    public List<PessoaDTO> findAll() {
        return repository.findAll().stream().map(MsPessoaFactory::fromEntity).collect(Collectors.toList());
    }

    public PessoaDTO findById(@PathVariable Long id) {

        Optional<Pessoa> optPessoa = repository.findById(id);

        if(optPessoa.isEmpty()) {
            throw new EntidadadeNaoEncontradaException("Pessoa", id);
        }

        return MsPessoaFactory.fromEntity(optPessoa.get());
    }
}
