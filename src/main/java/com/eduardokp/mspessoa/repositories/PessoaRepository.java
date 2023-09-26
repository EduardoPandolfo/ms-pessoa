package com.eduardokp.mspessoa.repositories;

import com.eduardokp.mspessoa.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
