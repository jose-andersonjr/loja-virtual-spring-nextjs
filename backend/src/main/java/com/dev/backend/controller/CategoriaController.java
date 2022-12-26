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

import com.dev.backend.entity.Categoria;
import com.dev.backend.service.CategoriaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService cs;

    @GetMapping("/")
    public List<Categoria> listarCategorias(){
        return cs.listarCategorias();
    }

    @PostMapping("/")
    public Categoria inserirCategoria(@RequestBody Categoria categoria){
        return cs.inserirCategoria(categoria);
    }

    @PutMapping("/")
    public Categoria alterarCategoria(@RequestBody Categoria categoria){
        return cs.alterarCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id){
        cs.deletarCategoria(id);
        return ResponseEntity.ok().build();
    }



}
