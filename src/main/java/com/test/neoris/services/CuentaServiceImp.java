package com.test.neoris.services;

import com.test.neoris.entities.CuentaEntity;
import com.test.neoris.interfaces.GenericService;
import com.test.neoris.repositorys.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("cuenta")
public class CuentaServiceImp implements GenericService {
    @Autowired
    CuentaRepository cuentaRepository;

    @Override
    public void save(Object cuenta){
        cuentaRepository.save((CuentaEntity) cuenta);
    }
    @Override
    public CuentaEntity find(Integer idCuenta){
        return (CuentaEntity)  cuentaRepository.findById(idCuenta).orElse(new CuentaEntity());
    }

    @Override
    public List<CuentaEntity> findAll(){
        return cuentaRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        cuentaRepository.deleteById(id);
    }

}
