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

    public List<Cidade> listar(){
        return cr.findAll();
    }

    public Cidade inserir(Cidade cidade){
        cidade.setDataCriacao(new Date());
        Cidade cidadeNova = cr.saveAndFlush(cidade);
        return cidadeNova;

    }

    public Cidade alterar(Cidade cidade){
        Cidade cidadeAntiga = cr.findById(cidade.getId()).get();
        cidade.setDataCriacao(cidadeAntiga.getDataCriacao());
        cidade.setDataAtualizacao(new Date());
        return cr.saveAndFlush(cidade);

    }

    public void deletar(Long id){
        Cidade cidade = cr.findById(id).get();
        cr.delete(cidade);
    }
    
}
