package com.eduardokp.mspessoa.repositories;

import com.eduardokp.mspessoa.entities.PessoaEndereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Long> {


    List<PessoaEndereco> findByPessoaId(Long pessoaId);
}
