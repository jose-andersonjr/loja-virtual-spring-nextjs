package com.dev.backend.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.backend.entity.Marca;
import com.dev.backend.repository.MarcaRepository;

@Service
public class MarcaService {
    
    @Autowired
    private MarcaRepository mr;

    public List<Marca> listarMarcas(){
        return mr.findAll();
    }

    public Marca inserirMarca(Marca marca){

        marca.setDataCriacao(new Date());
        Marca novaMarca = mr.saveAndFlush(marca);
        return novaMarca;
    }

    public Marca alterarMarca(Marca marca){
        Marca marcaAntiga = mr.findById(marca.getId()).get();
        marca.setDataCriacao(marcaAntiga.getDataCriacao());
        marca.setDataAtualizacao(new Date());
        return mr.saveAndFlush(marca);
    }

    public void deletarMarca(Long id){
        try {
            Marca marcaExcluir = mr.findById(id).get();
            marcaExcluir.setDataAtualizacao(new Date());
            mr.deleteById(id);
        } catch (Exception e) {
            System.out.println("A marca solicitado não foi encontrado! A mensagem de erro é: " + e);
        }
    }


}
