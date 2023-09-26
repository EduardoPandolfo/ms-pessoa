package com.eduardokp.mspessoa.controller;

import com.eduardokp.mspessoa.dtos.PessoaDTO;
import com.eduardokp.mspessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody PessoaDTO dto) {
        Long id = service.create(dto);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @Valid @RequestBody PessoaDTO dto) {
        service.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> getById(@PathVariable Long id) {
        PessoaDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> getAll() {
        List<PessoaDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }


}
