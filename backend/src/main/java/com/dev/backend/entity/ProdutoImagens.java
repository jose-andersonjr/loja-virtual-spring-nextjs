package com.dev.backend.entity;

import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Table(name = "ProdutoImagens")
@Entity
@Data
public class ProdutoImagens {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idProdutoImagens")
    private Long idProdutoImagens;
    
    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Long idProduto;

    @Column(name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    
    
}
