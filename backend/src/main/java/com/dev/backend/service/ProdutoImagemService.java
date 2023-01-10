package com.dev.backend.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.entity.ProdutoImagem;
import com.dev.backend.repository.ProdutoImagemRepository;

@Service
public class ProdutoImagemService {
    
    @Autowired
    private ProdutoImagemRepository pir;

    public List<ProdutoImagem> listarProdutoImagems(){
        return pir.findAll();
    }

    public ProdutoImagem inserirProdutoImagem(Long idProduto, MultipartFile file){
        ProdutoImagem novoProdutoImagem = new ProdutoImagem();
        novoProdutoImagem.setDataCriacao(new Date());
        novoProdutoImagem = ProdutoImagemRepository.saveAndFlush();
        
        return novoProdutoImagem;
    }

    public ProdutoImagem alterarProdutoImagem(ProdutoImagem produtoImagem){
        produtoImagem.setDataAtualizacao(new Date());
        return pir.saveAndFlush(produtoImagem);
    }

    public void deletarProdutoImagem(Long id){
        try {
            ProdutoImagem produtoImagemExcluir = pir.findById(id).get();
            produtoImagemExcluir.setDataAtualizacao(new Date());
            pir.deleteById(id);
        } catch (Exception e) {
            System.out.println("A produtoImagem solicitado não foi encontrado! A mensagem de erro é: " + e);
        }
    }


}
