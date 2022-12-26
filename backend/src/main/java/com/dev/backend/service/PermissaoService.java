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
    private PermissaoRepository mr;

    public List<Permissao> listarPermissoes(){
        return mr.findAll();
    }

    public Permissao inserirPermissao(Permissao permissao){

        permissao.setDataCriacao(new Date());
        Permissao novaPermissao = mr.saveAndFlush(permissao);
        return novaPermissao;
    }

    public Permissao alterarPermissao(Permissao permissao){
        Permissao permissaoAntiga = mr.findById(permissao.getId()).get();
        permissao.setDataCriacao(permissaoAntiga.getDataCriacao());
        permissao.setDataAtualizacao(new Date());
        return mr.saveAndFlush(permissao);
    }

    public void deletarPermissao(Long id){
        try {
            Permissao permissaoExcluir = mr.findById(id).get();
            permissaoExcluir.setDataAtualizacao(new Date());
            mr.deleteById(id);
        } catch (Exception e) {
            System.out.println("A permissao solicitado não foi encontrado! A mensagem de erro é: " + e);
        }
    }


}
