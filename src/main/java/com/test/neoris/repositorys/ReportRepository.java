package com.test.neoris.repositorys;

import com.test.neoris.entities.ReporteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends CrudRepository<ReporteEntity, Long> {
    @Query(
            value = "SELECT m.id_movimiento, m.fecha, p.nombre , c.numero_cuenta , c.tipo_cuenta , c.saldo_inicial , m.valor , c.estado,\n" +
                    "CASE \n" +
                    "   WHEN m.tipo_movimiento = 'credito' THEN m.valor \n" +
                    "   WHEN m.tipo_movimiento = 'debito' THEN CONCAT('-', m.valor)\n" +
                    "   END movimiento,\n" +
                    "m.saldo AS saldo_disponible\n" +
                    "FROM movimientos m\n" +
                    "INNER JOIN cuenta c ON m.fk_id_cuenta = c.id_cuenta \n" +
                    "INNER JOIN cliente cl ON c.fk_id_cliente = cl.id_cliente \n" +
                    "INNER JOIN persona p ON p.id_persona = cl.fk_id_persona \n" +
                    "WHERE cl.id_cliente = :id_cliente\n" +
                    "AND m.fecha = :fechas ",
            nativeQuery = true)
    List<ReporteEntity> findLastSaldo(@Param("id_cliente")  Integer idCliente, String fechas);
}
