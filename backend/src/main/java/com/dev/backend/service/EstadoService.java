package com.dev.backend.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.backend.entity.Estado;
import com.dev.backend.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository er;

    public List<Estado> listar(){
        return er.findAll();
    }

    public Estado inserir(Estado estado){
        
        estado.setDataCriacao(new Date());
        Estado estadoNovo = er.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterar(Estado estadoAtual){
        estadoAtual.setDataAtualizacao(new Date());
        return er.saveAndFlush(estadoAtual);
    }

    public void deletar(Long id){
        try {
            Estado estadoExcluir = er.findById(id).get();
            estadoExcluir.setDataAtualizacao(new Date());
            er.deleteById(id);
        } catch (Exception e) {
            System.out.println("O estado solicitado não foi encontrado! A mensagem de erro é: " + e);
        }
    }

}
