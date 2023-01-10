package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.entity.ProdutoImagens;
import com.dev.backend.repository.ProdutoImagensRepository;

@Service
public class ProdutoImagensService {
    
    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;

    @Autowired 
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagens> listarProdutoImagens(){
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagens inserirProdutoImagens(Long idProduto, MultipartFile file){
        ProdutoImagens produtoImagem = new ProdutoImagens();
        Produto produto = produtoRepository.findById(idProduto);
        produtoImagem.setDataCriacao(new Date());

        return null;
    }
}
