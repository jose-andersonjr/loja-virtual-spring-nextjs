package com.dev.backend.controller;

import java.util.Date;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dev.backend.entity.Estado;
import com.dev.backend.service.EstadoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class EstadoController {

    @Autowired
    EstadoService es;

    @PostMapping("/inserir")
    public Estado inserirEstado(@RequestBody Estado estado){
        return es.inserir(estado);
    }

    @GetMapping("/")
    public List<Estado> listarEstados(){
        return es.buscarTodos();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEstado(@PathVariable Long id){
        es.excluirEstado(id);
        return ResponseEntity.ok().build();
    }

}
