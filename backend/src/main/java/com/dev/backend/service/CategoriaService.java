package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Categoria;
import com.dev.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository cr;

    public List<Categoria> listar(){
        return cr.findAll();
    }

    public Categoria inserir(Categoria categoria){

        categoria.setDataCriacao(new Date());
        Categoria novaCategoria = cr.saveAndFlush(categoria);
        return novaCategoria;
    }

    public Categoria alterar(Categoria categoria){
        categoria.setDataAtualizacao(new Date());
        return cr.saveAndFlush(categoria);
    }

    public void deletar(Long id){
        try {
            Categoria categoriaExcluir = cr.findById(id).get();
            categoriaExcluir.setDataAtualizacao(new Date());
            cr.deleteById(id);
        } catch (Exception e) {
            System.out.println("A categoria solicitado não foi encontrado! A mensagem de erro é: " + e);
        }
    }


}
