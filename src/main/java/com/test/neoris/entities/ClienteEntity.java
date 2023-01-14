package com.test.neoris.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClienteEntity implements Serializable  {
    @Column(name = "id_cliente")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    @Column(name = "contrasena")
    private String password;
    @Column(name = "estado")
    private Integer state;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_id_persona")
    private PersonaEntity PersonaEntity;
}
