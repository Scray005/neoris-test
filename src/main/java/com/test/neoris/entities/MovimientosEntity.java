package com.test.neoris.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "movimientos")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MovimientosEntity implements Serializable {

    @Column(name = "id_movimiento")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    @Column(name = "fecha")
    private LocalDate date;
    @Column(name = "tipo_movimiento")
    private String movementType;
    @Column(name = "valor")
    private BigDecimal amount;
    @Column(name = "saldo")
    private BigDecimal balance;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_id_cuenta")
    private CuentaEntity cuentaEntity;
}
