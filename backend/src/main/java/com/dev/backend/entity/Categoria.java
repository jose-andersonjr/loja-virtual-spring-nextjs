package com.dev.backend.entity;

import java.util.Date;
<<<<<<< HEAD
=======

>>>>>>> f2bf04d651f3e0c868fb591b2aa9035ac233b0e5
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
<<<<<<< HEAD
@Table(name="categoria")
@Data
public class Categoria {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
=======
@Table(name = "categoria")
@Data
public class Categoria {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
>>>>>>> f2bf04d651f3e0c868fb591b2aa9035ac233b0e5
    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
<<<<<<< HEAD
    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;
=======
    @Column(name="data_atualizacao")
    private Date dataAtualizacao;
    
>>>>>>> f2bf04d651f3e0c868fb591b2aa9035ac233b0e5

}
