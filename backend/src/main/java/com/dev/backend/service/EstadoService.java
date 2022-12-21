package com.dev.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Estado;
import com.dev.backend.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository er;

    public Estado inserir(Estado estado){
        
        estado.setDataCriacao(new Date());
        Estado estadoNovo = er.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterar(Estado estado){
        
        estado.setDataAtualizacao(new Date());
        Estado estadoEditado = er.saveAndFlush(estado);
        return estadoEditado;
    }

    public void excluirEstado(Long id){
        try {
            Estado estadoExcluir = er.findById(id).get();
            estadoExcluir.setDataAtualizacao(new Date());
            er.deleteById(id);
        } catch (Exception e) {
            System.out.println("O estado solicitado não foi encontrado! A mensagem de erro é: " + e);
        }
    }

    public List<Estado> buscarTodos(){
        return er.findAll();
    }
}
