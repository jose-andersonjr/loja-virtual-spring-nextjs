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

    public List<Categoria> listarCategorias(){
        return cr.findAll();
    }

    public Categoria inserirCategoria(Categoria categoria){

        categoria.setDataCriacao(new Date());
        Categoria novaCategoria = cr.saveAndFlush(categoria);
        return novaCategoria;
    }

    public Categoria alterarCategoria(Categoria categoria){
        Categoria categoriaAntiga = cr.findById(categoria.getId()).get();
        categoria.setDataCriacao(categoriaAntiga.getDataCriacao());
        categoria.setDataAtualizacao(new Date());
        return cr.saveAndFlush(categoria);
    }

    public void deletarCategoria(Long id){
        try {
            Categoria categoriaExcluir = cr.findById(id).get();
            categoriaExcluir.setDataAtualizacao(new Date());
            cr.deleteById(id);
        } catch (Exception e) {
            System.out.println("A categoria solicitado não foi encontrado! A mensagem de erro é: " + e);
        }
    }


}
