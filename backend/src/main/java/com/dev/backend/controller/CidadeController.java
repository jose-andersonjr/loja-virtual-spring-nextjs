package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.Cidade;
import com.dev.backend.service.CidadeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    CidadeService cs;

    @GetMapping("/")
    public List<Cidade> listarCidades(){
        return cs.listarCidades();
    }
    
}
