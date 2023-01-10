package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;

@Service
public class PessoaService { 

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    public Pessoa inserir(Pessoa permissao){
        permissao.setDataCriacao(new Date());
        Pessoa novaPessoa = pessoaRepository.saveAndFlush(permissao);
        return novaPessoa;
    }

    public Pessoa alterar(Pessoa permissao){
        permissao.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(permissao);
    }

    public void deletar(Long id){
        try {
            Pessoa permissaoExcluir = pessoaRepository.findById(id).get();
            permissaoExcluir.setDataAtualizacao(new Date());
            pessoaRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("A permissao solicitado não foi encontrado! A mensagem de erro é: " + e);
        }
    }
}
