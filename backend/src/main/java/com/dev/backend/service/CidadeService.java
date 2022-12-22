package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Cidade;
import com.dev.backend.repository.CidadeRepository;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cr;

    public List<Cidade> listarCidades(){
        return cr.findAll();
    }

    public Cidade adicionarCidade(Cidade cidade){
        
        cidade.setDataCriacao(new Date());
        return cr.saveAndFlush(cidade);

    }
    
}