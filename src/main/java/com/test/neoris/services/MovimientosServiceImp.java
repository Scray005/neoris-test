package com.test.neoris.services;

import com.test.neoris.entities.MovimientosEntity;
import com.test.neoris.exception.TryExeception;
import com.test.neoris.interfaces.GenericService;
import com.test.neoris.repositorys.MovimientosRepository;
import com.test.neoris.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Qualifier("movimientos")
public class MovimientosServiceImp implements GenericService {
    @Autowired
    MovimientosRepository movimientosRepository;
    @Override
    public void save(Object movimientos) throws TryExeception{
        MovimientosEntity movimiento = (MovimientosEntity) movimientos;
        BigDecimal saldo = movimientosRepository.findLastSaldo(((MovimientosEntity) movimientos).getCuentaEntity().getId());
        if ( movimiento.getMovementType().equals(Constant.TIPO_CREDITO)){
            saldo = saldo.add(movimiento.getAmount());
            movimiento.setBalance(saldo);
        }else if(movimiento.getMovementType().equals(Constant.TIPO_DEBITO)){
            if(saldo.compareTo(new BigDecimal(0)) == 0){
                throw new TryExeception(Constant.SALDO_ZERO);
            }
            saldo = saldo.subtract(movimiento.getAmount());
            movimiento.setBalance(saldo);
        }
        movimientosRepository.save((MovimientosEntity) movimientos);
    }
    @Override
    public MovimientosEntity find(Integer idMovimiento){
        return (MovimientosEntity)  movimientosRepository.findById(idMovimiento).orElse(new MovimientosEntity());
    }

    @Override
    public List<MovimientosEntity> findAll(){
        return movimientosRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        movimientosRepository.deleteById(id);
    }
}
