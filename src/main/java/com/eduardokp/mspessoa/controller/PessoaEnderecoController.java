package com.eduardokp.mspessoa.controller;

import com.eduardokp.mspessoa.dtos.PessoaEnderecoDTO;
import com.eduardokp.mspessoa.service.PessoaEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/endereco")
public class PessoaEnderecoController {

    @Autowired
    private PessoaEnderecoService service;

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody PessoaEnderecoDTO dto) {
        Long id = service.create(dto);
        return ResponseEntity.ok(id);
    }

    @GetMapping(value = "/pessoa/{pessoaId}")
    public ResponseEntity<List<PessoaEnderecoDTO>> findById(@PathVariable Long pessoaId) {
        return ResponseEntity.ok(service.findAllByPessoaId(pessoaId));
    }
}
