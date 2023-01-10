package com.dev.backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.entity.Produto;
import com.dev.backend.entity.ProdutoImagens;
import com.dev.backend.repository.ProdutoImagensRepository;
import com.dev.backend.repository.ProdutoRepository;

@Service
public class ProdutoImagensService {
    
    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;

    @Autowired 
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagens> listar(){
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagens inserir(Long idProduto, MultipartFile file){
        ProdutoImagens produtoImagem = new ProdutoImagens();
        Produto produto = produtoRepository.findById(idProduto).get();

        try {
            if (!file.isEmpty()){
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getIdProduto()) + file.getOriginalFilename();
                Path caminho = Paths.get("c:/imagens/" + nomeImagem);
                Files.write(caminho, bytes);
                produtoImagem.setNome(nomeImagem);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        produtoImagem.setProduto(produto);
        produtoImagem.setDataCriacao(new Date());
        produtoImagem = produtoImagensRepository.saveAndFlush(produtoImagem);
        return produtoImagem;
    }

    public ProdutoImagens alterar(ProdutoImagens produtoImagem){
        produtoImagem.setDataAtualizacao(new Date());
        return produtoImagensRepository.saveAndFlush(produtoImagem);
    }

    public void deletar(Long idProdutoImagens){
        try{
            produtoImagensRepository.deleteById(idProdutoImagens);
        }catch (Exception e){
            System.out.println("O ProdutoImagem não foi encontrado");
        }
        
    }
}
