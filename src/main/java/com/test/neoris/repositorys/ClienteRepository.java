package com.test.neoris.repositorys;

import com.test.neoris.entities.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Integer> {
    List<ClienteEntity> findAll();
}
