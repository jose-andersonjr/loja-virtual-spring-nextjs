package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.service.PessoaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    //GET
    @GetMapping("/")
    public List<Pessoa> listarPessoas(){
        return pessoaService.listar();
    }

    //POST
    @PostMapping("/")
    public Pessoa inserirPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.inserir(pessoa);
    }

    //PUT
    @PutMapping("/")
    public Pessoa alterarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.alterar(pessoa);
    }

    //DELETE
    @DeleteMapping("/")
    public ResponseEntity<Void> deletarPessoa(@PathVariable("idPessoa") Long idPessoa){
        pessoaService.deletar(idPessoa);
        return ResponseEntity.ok().build();
    }
}
