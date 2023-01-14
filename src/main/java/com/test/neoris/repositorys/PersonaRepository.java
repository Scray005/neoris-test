package com.test.neoris.repositorys;

import com.test.neoris.entities.PersonaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends CrudRepository<PersonaEntity, Integer> {
    List<PersonaEntity> findAll();

}
