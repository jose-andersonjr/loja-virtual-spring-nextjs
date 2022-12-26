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
import com.dev.backend.entity.Permissao;
import com.dev.backend.service.PermissaoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/permissao")
public class PermissaoController {

    @Autowired
    PermissaoService es;

    @GetMapping("/")
    public List<Permissao> listarPermissoes(){
        return es.listarPermissoes();
    }

    @PostMapping("/")
    public Permissao inserirPermissao(@RequestBody Permissao permissao){
        return es.inserirPermissao(permissao);
    }

    @PutMapping("/")
    public Permissao alterarPermissao(@RequestBody Permissao permissao){
        return es.alterarPermissao(permissao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPermissao(@PathVariable Long id){
        es.deletarPermissao(id);
        return ResponseEntity.ok().build();
    }



}
