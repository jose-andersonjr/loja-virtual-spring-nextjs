package com.dev.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.dto.PessoaClienteRequestDTO;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.service.PessoaClienteService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cliente")
public class PessoaClienteController {

    @Autowired
    private PessoaClienteService pessoaClienteService;

    //POST
    @PostMapping("/")
    public Pessoa inserirPessoaCliente(@RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO){
        return pessoaClienteService.registrar(pessoaClienteRequestDTO);
    }


}
