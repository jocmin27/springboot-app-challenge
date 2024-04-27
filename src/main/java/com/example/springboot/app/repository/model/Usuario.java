package com.example.springboot.app.repository.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "tbl_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "peso")
    private double peso;
}
