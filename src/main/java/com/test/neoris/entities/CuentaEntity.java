package com.test.neoris.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "cuenta")
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CuentaEntity implements Serializable {

    @Column(name = "id_cuenta")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    @Column(name = "numero_cuenta")
    private Integer accountNumber;
    @Column(name = "tipo_cuenta")
    private String accountType;
    @Column(name = "saldo_inicial")
    private BigDecimal initialBalance;
    @Column(name = "estado")
    private String state;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_id_cliente")
    private ClienteEntity clienteEntity;

}