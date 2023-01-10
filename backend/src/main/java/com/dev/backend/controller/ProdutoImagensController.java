package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.dev.backend.entity.ProdutoImagens;
import com.dev.backend.service.ProdutoImagensService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/produtoImagens")
public class ProdutoImagensController {

    @Autowired
    private ProdutoImagensService produtoImagensService;

    // GET
    @GetMapping("/")
    public List<ProdutoImagens> listarProdutoImagens(){
        return produtoImagensService.listar();
    }

    // POST
    @PostMapping("/")
    public ProdutoImagens inserirProdutoImagens(@RequestParam("idProduto") Long idProduto, @RequestParam("file") MultipartFile file){
        return produtoImagensService.inserir(idProduto, file);
    }

    // PUT
    @PutMapping("/")
    public ProdutoImagens alterarProdutoImagens(@RequestBody ProdutoImagens produtoImagens){
        return produtoImagensService.alterar(produtoImagens);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletarProdutoImagens(@PathVariable("id") Long idProdutoImagens){
        produtoImagensService.deletar(idProdutoImagens);
    }
    
}
