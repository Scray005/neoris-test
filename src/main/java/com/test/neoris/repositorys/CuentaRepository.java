package com.test.neoris.repositorys;

import com.test.neoris.entities.CuentaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends CrudRepository<CuentaEntity, Integer> {
    List<CuentaEntity> findAll();
}
