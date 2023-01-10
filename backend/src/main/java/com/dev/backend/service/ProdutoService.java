package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Produto;
import com.dev.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired 
    private ProdutoRepository produtoRepository;

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public Produto inserir(Produto produto){
        produto.setDataCriacao(new Date());
        return produtoRepository.saveAndFlush(produto);
    }

    public Produto alterar(Produto produto){
        produto.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(produto);
    }
    
    public void deletar(Long idProduto){
        try{
            produtoRepository.deleteById(idProduto);
        }catch (Exception e){
            System.out.println("O ProdutoImagem não foi encontrado");
        }
        
    }
}
