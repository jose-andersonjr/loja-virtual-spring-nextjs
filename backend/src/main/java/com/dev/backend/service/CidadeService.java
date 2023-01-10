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

    public Cidade inserirCidade(Cidade cidade){
        cidade.setDataCriacao(new Date());
        Cidade cidadeNova = cr.saveAndFlush(cidade);
        return cidadeNova;

    }

<<<<<<< HEAD
    public Cidade editarCidade(Cidade cidade){
        Cidade cidadeAntiga = cr.findById(cidade.getId()).get();
        cidade.setDataCriacao(cidadeAntiga.getDataCriacao());
        cidade.setDataAtualizacao(new Date());
        return cr.saveAndFlush(cidade);

    }

    public void deletarCidade(Long id){
        Cidade cidade = cr.findById(id).get();
        cr.delete(cidade);
=======
    public Cidade alterarCidade(Cidade cidade){
        cidade.setDataAtualizacao(new Date());
        return cr.saveAndFlush(cidade);
>>>>>>> f2bf04d651f3e0c868fb591b2aa9035ac233b0e5
    }
    
    public void deletarCidade(Long id){
        cr.deleteById(id);
        
    }
}
