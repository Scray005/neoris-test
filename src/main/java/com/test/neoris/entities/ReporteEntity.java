package com.test.neoris.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class ReporteEntity {

    @Id
    @Column(name = "id_movimiento")
    private Integer id;
    @Column(name = "fecha")
    public String fecha;
    @Column(name ="nombre")
    public String cliente;
    @Column(name ="numero_cuenta")
    public String numeroCuenta;
    @Column(name ="tipo_cuenta")
    public String tipo;
    @Column(name ="valor")
    public BigDecimal saldoInicial;
    @Column(name ="estado")
    public boolean estado;
    @Column(name ="movimiento")
    public String movimiento;
    @Column(name ="saldo_disponible")
    public BigDecimal saldoDisponible;
}
