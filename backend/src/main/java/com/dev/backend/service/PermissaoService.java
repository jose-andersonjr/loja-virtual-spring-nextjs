package com.dev.backend.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.backend.entity.Permissao;
import com.dev.backend.repository.PermissaoRepository;

@Service
public class PermissaoService {
    
    @Autowired
    private PermissaoRepository pr;

    public List<Permissao> listar(){
        return pr.findAll();
    }

    public Permissao inserir(Permissao permissao){

        permissao.setDataCriacao(new Date());
        Permissao novaPermissao = pr.saveAndFlush(permissao);
        return novaPermissao;
    }

    public Permissao alterar(Permissao permissao){
        permissao.setDataAtualizacao(new Date());
        return pr.saveAndFlush(permissao);
    }

    public void deletar(Long id){
        try {
            Permissao permissaoExcluir = pr.findById(id).get();
            permissaoExcluir.setDataAtualizacao(new Date());
            pr.deleteById(id);
        } catch (Exception e) {
            System.out.println("A permissao solicitado não foi encontrado! A mensagem de erro é: " + e);
        }
    }


}
