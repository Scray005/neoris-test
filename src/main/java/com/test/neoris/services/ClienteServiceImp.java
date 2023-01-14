package com.test.neoris.services;

import com.test.neoris.entities.ClienteEntity;
import com.test.neoris.interfaces.GenericService;
import com.test.neoris.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("cliente")
public class ClienteServiceImp implements GenericService {
    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public void save(Object cliente){
        clienteRepository.save((ClienteEntity) cliente);
    }
    @Override
    public ClienteEntity find(Integer idCliente){
        return (ClienteEntity)  clienteRepository.findById(idCliente).orElse(new ClienteEntity());
    }
    @Override
    public List<ClienteEntity> findAll(){
        return clienteRepository.findAll();
    }
    @Override
    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }

}
