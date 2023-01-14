package com.test.neoris.repositorys;

import com.test.neoris.entities.MovimientosEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MovimientosRepository extends CrudRepository<MovimientosEntity, Integer> {
    List<MovimientosEntity> findAll();
    @Query(
            value = "SELECT saldo \n" +
                    "FROM movimientos m \n" +
                    "WHERE m.fk_id_cuenta = :id_cuenta \n" +
                    "ORDER BY id_movimiento DESC \n" +
                    "LIMIT 1",
            nativeQuery = true)
    BigDecimal findLastSaldo(@Param("id_cuenta")  Integer idCuenta);
}
