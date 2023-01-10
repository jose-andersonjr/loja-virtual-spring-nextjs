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

import com.dev.backend.entity.Produto;
import com.dev.backend.service.ProdutoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    //GET
    @GetMapping("/")
    public List<Produto> listarProdutos(){
        return produtoService.listar();
    }

    //POST
    @PostMapping("/")
    public Produto inserirProduto(@RequestBody Produto produto){
        return produtoService.inserir(produto);
    }

    //PUT
    @PutMapping("/")
    public Produto alterarProduto(@RequestBody Produto produto){
        return produtoService.alterar(produto);
    }

    //DELETE
    @DeleteMapping("/")
    public ResponseEntity<Void> deletarProduto(@PathVariable("idProduto") Long idProduto){
        produtoService.deletar(idProduto);
        return ResponseEntity.ok().build();
    }
}
