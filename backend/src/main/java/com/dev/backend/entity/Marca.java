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
@Table(name = "marca")
@Data
public class Marca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_atualizacao")
=======
@Table(name="marca")
@Data
public class Marca {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name="data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
>>>>>>> f2bf04d651f3e0c868fb591b2aa9035ac233b0e5
    private Date dataAtualizacao;


}
