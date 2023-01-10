package com.dev.backend.entity;

import java.util.Date;

<<<<<<< HEAD
import jakarta.annotation.Generated;
=======
>>>>>>> f2bf04d651f3e0c868fb591b2aa9035ac233b0e5
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

<<<<<<< HEAD
@Table(name = "produto")
@Entity
=======
@Entity
@Table(name = "produto")
>>>>>>> f2bf04d651f3e0c868fb591b2aa9035ac233b0e5
@Data
public class Produto {
    
    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idProduto")
    private Long idProduto;
    
    @Column(name = "descricao_curta")
    private String descricaoCurta;

    @Column(name = "descricao_longa")
    private String descricaoLonga;

    @Column(name = "valorCusto")
    private Double valorCusto;

    @Column(name = "valorVenda")
=======
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "descricao_curta")
    private String descricaoCurta;

    @Column(name = "descricao_detalhada")
    private String descricaoDetalhada;

    @Column(name ="valor_custo")
    private Double valorCusto;

    @Column(name = "valor_venda")
>>>>>>> f2bf04d651f3e0c868fb591b2aa9035ac233b0e5
    private Double valorVenda;

    @ManyToOne
    @JoinColumn(name = "idMarca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

<<<<<<< HEAD
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;


=======
    @Column(name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    
>>>>>>> f2bf04d651f3e0c868fb591b2aa9035ac233b0e5
}
