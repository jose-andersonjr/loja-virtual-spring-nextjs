package com.dev.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dev.backend.entity.Marca;
import com.dev.backend.service.MarcaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    MarcaService ms;

    @GetMapping("/")
    public List<Marca> listarMarcas(){
        return ms.listar();
    }

    @PostMapping("/")
    public Marca inserirMarca(@RequestBody Marca marca){
        return ms.inserir(marca);
    }

    @PutMapping("/")
    public Marca alterarMarca(@RequestBody Marca marca){
        return ms.alterar(marca);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMarca(@PathVariable("id") Long id){
        ms.deletar(id);
        return ResponseEntity.ok().build();
    }



}
