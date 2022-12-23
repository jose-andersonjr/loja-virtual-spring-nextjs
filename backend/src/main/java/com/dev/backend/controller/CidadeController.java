package com.dev.backend.controller;

import java.util.List;
import java.util.Optional;

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

import com.dev.backend.entity.Cidade;
import com.dev.backend.service.CidadeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cs;

    @GetMapping("/")
    public List<Cidade> listarCidades(){
        return cs.listarCidades();
    }

    @PostMapping("/")
    public Cidade adicionarCidade(@RequestBody Cidade cidade){
        return cs.adicionarCidade(cidade);
    }

    @PutMapping("/")
    public Cidade editarCidade(@RequestBody Cidade cidade){
        return cs.editarCidade(cidade);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deletarCidade(@PathVariable Long id){
        cs.deletarCidade(id);
        return ResponseEntity.ok().build();
    }
    
}
