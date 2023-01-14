package com.test.neoris.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persona")
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PersonaEntity implements Serializable {
    @Column(name = "id_persona")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "genero")
    private char gender;
    @Column(name = "edad")
    private Integer age;
    @Column(name = "identificacion")
    private Integer identification;
    @Column(name = "direccion")
    private String address;
    @Column(name = "telefono")
    private String telephone;
}
